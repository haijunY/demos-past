package com.yhj.study.concurrency.work.d190508;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 背景：白名单用户导入系统
 * @date: 2019/05/10 11:15
 */
public class WhiteRosterTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for(long i = 1;i <= 3; i++){
            users.add(new User(i, "用户"+i));
        }

        //不使用多线程
        WhiteRosterService whiteRosterService = new WhiteRosterServiceImpl();
        long startTime = new Date().getTime();
        whiteRosterService.add(users);
        long endTime = new Date().getTime();
        System.out.println("耗时：" + (endTime - startTime) + "ms");

        //使用多线程
        long startTime1 = new Date().getTime();
        whiteRosterService.concurrencyAdd(users);
        long endTime1 = new Date().getTime();
        System.out.println("使用多线程耗时：" + (endTime1 - startTime1) + "ms");

    }

}
