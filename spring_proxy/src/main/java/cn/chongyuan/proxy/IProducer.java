package cn.chongyuan.proxy;

/*
 * 对生产厂家要求的接口
 * */
public interface IProducer {
    void saleProduce(float money);

    void afterService(float money);
}
