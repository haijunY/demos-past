package com.yhj.study.designpattern.battercake.v2;

public class BattercakeTest {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + ",总价格：" + battercake.price());
        Battercake battercakeEgg = new EggDecorator(battercake);
        System.out.println(battercakeEgg.getMsg() + ",总价格：" + battercakeEgg.price());
        Battercake battercakeSausage = new SausageDecortor(battercake);
        System.out.println(battercakeSausage.getMsg() + ",总价格：" + battercakeSausage.price());
        Battercake battercakeEggSausage = new SausageDecortor(battercakeEgg);
        System.out.println(battercakeEggSausage.getMsg() + ",总价格：" + battercakeEggSausage.price());
        Battercake battercake2EggSausage = new EggDecorator(battercakeEggSausage);
        System.out.println(battercake2EggSausage.getMsg() + ",总价格：" + battercake2EggSausage.price());


    }

}
