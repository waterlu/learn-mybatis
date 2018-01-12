package cn.lu.learn;

import cn.lu.learn.aop.ProductMapper;
import cn.lu.learn.aop.ProxyHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lutiehua
 * @date 2018/1/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTests {

    private final Logger logger = LoggerFactory.getLogger(ProxyTests.class);

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void contextLoads() {
//        testDynamicProxy();
        testAop();
    }


    void testDynamicProxy() {
//		logger.info("product1=[{}]", productMapper.select(1L));

        // 创建代理
        ProxyHandler proxyHandler = new ProxyHandler();
        // 生成代理接口
        ProductMapper productMapperProxy = (ProductMapper)proxyHandler.bind(productMapper);
        // 调用代理接口
        logger.info("product1=[{}]", productMapperProxy.select(1L));

        // 核心是调用了Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)方法
    }

    void testAop() {

    }
}
