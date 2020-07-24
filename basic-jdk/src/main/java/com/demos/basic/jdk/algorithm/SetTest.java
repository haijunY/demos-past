package com.demos.basic.jdk.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yinhaijun
 * @date: 2020/7/21
 */
public class SetTest {

    public static void  main(String[] args){
        Set<Long> storeIdsByStroreName = new HashSet<>();
        storeIdsByStroreName.add(1L);
        storeIdsByStroreName.add(2L);
        storeIdsByStroreName.add(3L);
        Set<Long> storeIds = new HashSet<>();
        storeIds.add(2L);
        storeIds.add(3L);
        storeIds.add(5L);
        if(null != storeIdsByStroreName && !storeIdsByStroreName.isEmpty()){
            List<Long> collect = storeIdsByStroreName.stream().filter(x -> {
                return storeIds.contains(x);
            }).collect(Collectors.toList());
            for(Long s : collect){
                System.out.println(s);
            }
        }
       }
}
