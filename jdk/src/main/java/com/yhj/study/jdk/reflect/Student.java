package com.yhj.study.jdk.reflect;

public class Student {

    public String name;

    private int age;

    public Student(){

    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    private Student(int age){
        this.name = "亲儿子";
        this.age = age;
    }

    public void learning(String course){
        System.out.println("正在学习" + course);
    }

    private String think(String question){
        System.out.println("正在思考" + question);
        return "已攻克";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
