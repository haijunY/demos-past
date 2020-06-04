package com.yhj.study.jdk.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> arr1 = new ArrayList<>();
        arr1.add("2");
        arr1.add("0");
        arr1.add("0");

        //错误
//        for(String arr : arr1){
//            if(Integer.valueOf(arr) == 0){
//                arr1.remove(arr);
//            }
//        }

        //错误
//        for (int i = 0; i < arr1.size(); i++) {
//            if(Integer.valueOf(arr1.get(i)) == 0){
//                arr1.remove(arr1.get(i));
//            }
//        }

        //正确写法一
//        for (int i = arr1.size()-1; i >= 0; i--) {
//            if(Integer.valueOf(arr1.get(i)) == 0){
//                arr1.remove(arr1.get(i));
//            }
//        }
        //正确写法二
        for (int i = 0; i < arr1.size(); i++) {
            if(Integer.valueOf(arr1.get(i)) == 0){
                arr1.remove(arr1.get(i));
                i = i-1;//移除后把下标恢复正常
            }
        }
        //正确写法三
//        Iterator<String> iterator = arr1.iterator();
//        while (iterator.hasNext()){
//            String it = iterator.next();
//            if(Integer.valueOf(it) == 0){
//                iterator.remove();
//            }
//        }

        System.out.println(Arrays.toString(arr1.toArray()));



    }

}
