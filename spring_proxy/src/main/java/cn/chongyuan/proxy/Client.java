package cn.chongyuan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final IProducer producer = new Produces();
        /*
         * 动态代理: 基于接口的代理
         *   字节码随用随创建,随用随加载
         *   作用:不修改源码请改的情况下对方法增强
         *   分类:
         *       1.基于接口的动态代理
         *       2.基于子类的动态代理
         *   基于接口的动态代码
         *       涉及的类:Proxy
         *       提供者:JDK官方
         *
         * */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强的代码
                        Object returnValue = null;
                        // 1.获取方法执行的参数
                        Float money = (Float) args[0];
                        // 2.判断当前方法是不是销售
                        if("saleProduce".equals(method.getName())){
                            returnValue=method.invoke(producer,money*0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduce(10000f);
    }
}
