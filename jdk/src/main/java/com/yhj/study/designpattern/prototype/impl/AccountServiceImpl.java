package com.yhj.study.designpattern.prototype.impl;

import com.yhj.study.designpattern.prototype.AccountService;
import com.yhj.study.designpattern.prototype.dto.Account;
import com.yhj.study.designpattern.prototype.dto.TransferModel;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @date: 2019/05/23 18:33
 */
public class AccountServiceImpl implements AccountService {

    //模拟数据库
    private static Map<String, Account> map = new ConcurrentHashMap<>();

    static {
        putAccount(new Account("1", "张三", new BigDecimal(4000)));
        putAccount(new Account("2", "李四", new BigDecimal(1000)));
        putAccount(new Account("3", "王五", new BigDecimal(1000)));
        putAccount(new Account("4", "赵柳", new BigDecimal(1000)));
    }

    private static void putAccount(Account account){
        map.put(account.getAccountId(), account);
    }

    private static Account getAccount(String accountId){
        try {
            //返回出的是一个新的对象
            return (Account) map.get(accountId).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean transfer(String accountId1, String accountId2, BigDecimal tradeAmount) {

        //初始化模型
        TransferModel model = new TransferModel();
        model.setAccount1(getAccount(accountId1));
        model.setAccount2(getAccount(accountId2));
        model.setTradeAmount(tradeAmount);

        //计算
        BigDecimal newBalance1 = model.getAccount1().getBalance().subtract(tradeAmount);
        model.getAccount1().setBalance(newBalance1);
        BigDecimal newBalance2 = model.getAccount2().getBalance().add(tradeAmount);
        model.getAccount2().setBalance(newBalance2);

        //存储
        saveModel(model);
        System.out.println("转账成功！！！");
        return true;
    }

    @Override
    public boolean transferMany(String accountId1, Map<String, BigDecimal> accountMap){
        Set<Map.Entry<String, BigDecimal>> set = accountMap.entrySet();
        Iterator<Map.Entry<String, BigDecimal>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, BigDecimal> entry = iterator.next();
            String accountId = entry.getKey();
            BigDecimal tradeAmount = entry.getValue();
            //偷懒的写法，如果其中一笔转账失败，无法做到回滚，而且频繁操作数据库，性能不好
            transfer(accountId1, accountId, tradeAmount);
        }
        return true;
    }

    //实际场景中还需要锁数据，校验数据，记log等等
    @Override
    public boolean transferManyAtomic(String accountId1, Map<String, BigDecimal> accountMap){

        //用于最终数据存储
        List<TransferModel> models = new ArrayList<>();

        //用于每次计算后的数据传递
        TransferModel nexModel = null;

        Set<Map.Entry<String, BigDecimal>> set = accountMap.entrySet();
        Iterator<Map.Entry<String, BigDecimal>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, BigDecimal> entry = iterator.next();
            String accountId = entry.getKey();
            BigDecimal tradeAmount = entry.getValue();

            //初始化模型
            if(null == nexModel){
                nexModel = new TransferModel();
                nexModel.setAccount1(getAccount(accountId1));
            }
            nexModel.setAccount2(getAccount(accountId));
            nexModel.setTradeAmount(tradeAmount);

            //计算
            BigDecimal newBalance1 = nexModel.getAccount1().getBalance().subtract(tradeAmount);
            nexModel.getAccount1().setBalance(newBalance1);
            BigDecimal newBalance2 = nexModel.getAccount2().getBalance().add(tradeAmount);
            nexModel.getAccount2().setBalance(newBalance2);
            try {
                //注意这里是精髓，克隆两个对象，一个用于数据保存，一个用于下一次转账的计算
                //必须克隆两个对象，否则会导致下一次计算的时候影响用于保存的model
                //这样做的好处是避免频繁去访问数据和修改数据，使得最终可以一起保存数据(从而实现事务一致性)
                TransferModel prototypeModel1 = (TransferModel) nexModel.clone();
                TransferModel prototypeModel2 = (TransferModel) nexModel.clone();
                models.add(prototypeModel1);
                nexModel = prototypeModel2;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        //这里需要去保存数据，实际业务场景中还需要记录log，所以需要把model进行save
        for(TransferModel smodel : models){
            saveModel(smodel);
        }
        return true;
    }


    private void saveModel(TransferModel model) {
        putAccount(model.getAccount1());
        putAccount(model.getAccount2());
    }



    @Override
    public void show(){
        //展示结果
        Set<Map.Entry<String, Account>> set = map.entrySet();
        Iterator<Map.Entry<String, Account>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Account> entry = iterator.next();
            Account a = entry.getValue();
            System.out.println("id：" + a.getAccountId() + "姓名：" + a.getAccountName() + "余额：" + a.getBalance());
        }
    }


}
