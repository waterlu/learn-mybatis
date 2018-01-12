package cn.lu.learn.demo4;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

/**
 * 传统方式是在web.xml中引用spring-mybatis.xml
 * 这里的WebConfig作用等同于web.xml
 *
 * @author lutiehua
 * @date 2018/1/12
 */
@Configuration
@ImportResource(locations={"classpath:spring-mybatis.xml"})
public class WebConfig {

    @Bean()
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://10.10.10.174:3306/luth?useUnicode=true&characterEncoding=utf8&useSSL=false");
        druidDataSource.setUsername("zj_admin");
        druidDataSource.setPassword("123456");
        druidDataSource.setInitialSize(3);
        druidDataSource.setMinIdle(3);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        return druidDataSource;
    }

    // 一样一样的
    // @Bean = <bean>

//    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
//        <property name="driverClassName" value="${driver}"/>
//        <property name="url" value="${url}"/>
//        <property name="username" value="${username}"/>
//        <property name="password" value="${password}"/>
//        <property name="initialSize" value="${druid.initialSize}"/>
//        <property name="minIdle" value="${druid.minIdle}"/>
//        <property name="maxActive" value="${druid.maxActive}"/>
//        <property name="maxWait" value="${druid.maxWait}"/>
//        <property name="timeBetweenEvictionRunsMillis" value="${druid.timeBetweenEvictionRunsMillis}"/>
//        <property name="minEvictableIdleTimeMillis" value="${druid.minEvictableIdleTimeMillis}"/>
//        <property name="validationQuery" value="${druid.validationQuery}"/>
//        <property name="testWhileIdle" value="${druid.testWhileIdle}"/>
//        <property name="testOnBorrow" value="${druid.testOnBorrow}"/>
//        <property name="testOnReturn" value="${druid.testOnReturn}"/>
//    </bean>

}