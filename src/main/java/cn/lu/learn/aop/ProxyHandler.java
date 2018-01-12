package cn.lu.learn.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lutiehua
 * @date 2018/1/12
 */
public class ProxyHandler implements InvocationHandler {

    private final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);

    /**
     * 被代理的对象
     */
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        // 把调用loader这个类的interfaces接口的方法教给h代理，触发h的invoke()方法
        // public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        // getInterfaces()返回接口，不是接口不能代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("proxy invoke begin");
        Object result = method.invoke(target, args);
        logger.info("proxy invoke end");
        return result;
    }
}
