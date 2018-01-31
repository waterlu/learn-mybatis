package cn.lu.learn.demo6;

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
//@Configuration
@ImportResource(locations={"classpath:spring-mybatis2.xml"})
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
}