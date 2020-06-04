package com.yhj.study.designpattern.proxy.staticproxy;


import com.yhj.study.designpattern.proxy.Person;

/**
 * @date: 2019/05/08 9:22
 */
public class Father {

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    public void findLove(){
        System.out.println("开始物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确立关系");
    }

}
