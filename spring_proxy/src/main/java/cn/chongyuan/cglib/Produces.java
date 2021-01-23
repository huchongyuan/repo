package cn.chongyuan.cglib;

import cn.chongyuan.proxy.IProducer;

/*
*
* 生产者
* */
public class Produces{
    // 销售
    public void saleProduce(float money){
        System.out.println("销售产品并且拿到钱..."+money);
    }
    // 售后
    public void afterService(float money){
        System.out.println("提供售后服务,并且拿到钱");
    }

}
