package cn.lu.learn.base1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lutiehua
 * @date 2018/1/8
 */
public class UserServiceProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        // 把调用loader这个类的interfaces接口的方法教给h代理，触发h的invoke()方法
        // public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke begin");
        Object result = method.invoke(target, args);
        System.out.println("invoke end");
        return result;
    }
}
