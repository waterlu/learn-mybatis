package cn.lu.learn.demo3;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
public class MyDataSourceFactory extends DruidDataSource implements DataSourceFactory {

    protected Properties properties;

    private DruidDataSource dataSource;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        if (null == dataSource) {
            dataSource = new DruidDataSource();
            // 应该怎么写？
            dataSource.setDriverClassName(properties.getProperty("driver"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setInitialSize(5);
            dataSource.setMinIdle(1);
            dataSource.setMaxActive(10);
        }

        return dataSource;
    }
}
