package com.yhj.study.concurrency.work.d190508;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @date: 2019/05/10 11:13
 */
public class WhiteRosterServiceImpl implements WhiteRosterService {

    @Override
    public boolean add(User user) {
        //模拟业务执行时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public int add(List<User> users) {
        int successCount = 0;
        for(User user : users){
            boolean addRes = add(user);
            if(addRes){
                successCount++;
            }else {
                System.out.println("本条执行失败，user=" + user);
            }
        }
        System.out.println("成功添加：" + successCount + "条");
        return successCount;

    }

    @Override
    public int concurrencyAdd(List<User> users) {
        ExecutorService executorService = Executors.newWorkStealingPool(3);
        int successCount = 0;
        List<Future<Boolean>> futures = new ArrayList<>();
        for (User user : users) {
            Future<Boolean> future = executorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return add(user);
                }

            });
            futures.add(future);
        }

        try {
            for(Future<Boolean> f : futures) {
                if ((Boolean) f.get()) {
                    successCount++;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("成功添加：" + successCount + "条");
        return successCount;
    }


}
