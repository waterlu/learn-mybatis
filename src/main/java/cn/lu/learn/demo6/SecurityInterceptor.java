package cn.lu.learn.demo6;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author lutiehua
 * @date 2018/1/16
 */
@Intercepts({
@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class SecurityInterceptor implements Interceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 加密
        encrypt(invocation);
        // 执行SQL
        Object returnValue = invocation.proceed();
        // 解密
        decrypt(returnValue);
        return returnValue;
    }

    private void encrypt(Invocation invocation) {
        MappedStatement statement = (MappedStatement)invocation.getArgs()[0];
    }

    private void decrypt(Object returnValue) {

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
