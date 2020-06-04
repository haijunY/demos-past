package com.yhj.study.designpattern.gpadvice;

public class ObserverTest {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("tom");

        Question question = new Question();

        question.setUserName("小明");
        question.setContent("观察者模式适合于哪些场景呢？");

        gPer.addObserver(tom);
        gPer.publishQuestion(question);

    }
}
