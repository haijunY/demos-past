package com.yhj.study.designpattern.prototype;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @date: 2019/05/23 18:32
 */
public interface AccountService {

    /** 单笔转账 */
    boolean transfer(String accountId1, String accountId2, BigDecimal tradeAmount);

    /** 一转多，普通 */
    boolean transferMany(String accountId1, Map<String, BigDecimal> accountMap);

    /** 一转多，原型写法，保证原子性，要么全部成功，要么全部失败 */
    boolean transferManyAtomic(String accountId1, Map<String, BigDecimal> accountMap);

    /** 展示数据 */
    void show();
}
