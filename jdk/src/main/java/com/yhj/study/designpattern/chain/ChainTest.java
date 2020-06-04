package com.yhj.study.designpattern.chain;

/**
 * 责任链设计模式，加入阻塞队列，可提高性能
 * @date: 2019/06/04 14:29
 */
public class ChainTest {

    static IRequestProcessor prevProcessor;

    static {
        PrintProcessor printProcessor = new PrintProcessor();
        printProcessor.start();
        SaveProcessor saveProcessor = new SaveProcessor(printProcessor);
        saveProcessor.start();
        prevProcessor = new PrevProcessor(saveProcessor);
        ((PrevProcessor)prevProcessor).start();
    }


    public static void main(String[] args) {
        Request request = new Request();
        request.setName("yhj");
        prevProcessor.process(request);
    }

}
