package com.demos.basic.designpattern.prototype;

import com.demos.basic.designpattern.prototype.impl.AccountServiceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2019/05/23 22:27
 */
public class PrototypeTest {
    static AccountService accountService = new AccountServiceImpl();

    public static void main(String[] args) {
        //单笔转账
//        accountService.transfer("1", "2", new BigDecimal(10));
//        accountService.show();

        //一转多，普通写法
        Map<String, BigDecimal> accountMap = new HashMap<>();
        accountMap.put("2", new BigDecimal(20));
        accountMap.put("3", new BigDecimal(30));
        accountMap.put("4", new BigDecimal(40));
//        accountService.transferMany("1", accountMap);
//        accountService.show();

        //一转多，原型写法
        accountService.transferManyAtomic("1", accountMap);
        accountService.show();
    }

}
