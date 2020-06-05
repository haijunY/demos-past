package com.demos.basic.designpattern.gpadvice;

import java.util.Observable;

public class GPer extends Observable {

    private String name = "沽泡生态圈";

    private static GPer gper = null;

    private GPer(){

    }

    public static GPer getInstance(){
        if(null == gper){
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了问题");
        setChanged();
        notifyObservers(question);
    }

}
