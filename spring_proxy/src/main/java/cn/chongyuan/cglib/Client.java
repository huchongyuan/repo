package cn.chongyuan.cglib;

import cn.chongyuan.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Produces produces = new Produces();
        /*
         * 动态代理: 基于子类的代理
         *   字节码随用随创建,随用随加载
         *   作用:不修改源码请改的情况下对方法增强
         *   分类:
         *       1.基于接口的动态代理
         *       2.基于子类的动态代理
         *   基于接口的动态代码
         *       涉及的类:Enhancer
         *       提供者:cglib
         *   如何创建代理对象
         *       使用Enhancer的create()方法
         *   创建代理对象的要求
         *       被代理类不能是最终类
         *
         *
         * */
        Enhancer.create(produces.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return null;
            }
        });
    }
}
