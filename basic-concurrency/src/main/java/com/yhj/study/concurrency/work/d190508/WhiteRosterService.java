package com.yhj.study.concurrency.work.d190508;

import java.util.List;

/**
 * @date: 2019/05/10 11:11
 */
public interface WhiteRosterService {

    /**
     * 返回结果
     */
    boolean add(User user);

    /**
     * 返回成功条数
     */
    int add(List<User> users);

    /**
     * 返回成功条数
     */
    int concurrencyAdd(List<User> users);

}
