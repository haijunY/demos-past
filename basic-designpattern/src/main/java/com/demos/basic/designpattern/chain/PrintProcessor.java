package com.demos.basic.designpattern.chain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @date: 2019/06/04 14:17
 */
public class PrintProcessor extends Thread implements IRequestProcessor {
    //阻塞队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private volatile boolean isFinish=false;

    public PrintProcessor() {

    }

    //对外提供关闭的方法
    public void shutDown() {
        isFinish = true;
    }

    private IRequestProcessor nextProcessor;


    public PrintProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void process(Request request) {
        //TODO
        //验证请求参数
        requests.add(request);

    }

    @Override
    public void run() {
        while (!isFinish){
            try {
                Request request = requests.take();//阻塞式获取数据
                //真正的处理逻辑
                System.out.println("PrintProcessor:" + request);
                //交给下一个责任链
                if(null != nextProcessor){
                    nextProcessor.process(request);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
