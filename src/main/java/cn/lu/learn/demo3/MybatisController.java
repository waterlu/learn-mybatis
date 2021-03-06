package cn.lu.learn.demo3;

import cn.lu.learn.entity.User;
import cn.lu.learn.mapper.UserMapper;
import com.google.common.base.Strings;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

/**
 * 只用Mybatis，不用Spring
 * org.mybatis:mybatis:3.4.0
 *
 * @author lutiehua
 * @date 2018/1/5
 */
@RestController
@RequestMapping("mybatis")
public class MybatisController {

    private final Logger logger = LoggerFactory.getLogger(MybatisController.class);

    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/query")
    public User query(@RequestParam String userUuid) {
        if (Strings.isNullOrEmpty(userUuid)) {
            return null;
        }

        return getUser(userUuid);
    }

    private User getUser(String userUuid) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSessionFactory().openSession();
            // sqlSession中配置了数据库链接，同时也配置了mapper的XML文件
            // 每个XML文件中，mapper的namespace就是它的key，通常这个key指向Mapper接口
            // 这样getMapper()相当于根据Mapper的类名获取XML文件的内容，就得到了需要执行的SQL语句
            User user = null;

            // 第一种方法，SqlSession的Configuration中，Map的Key有全称和简称两种，"queryByUuid"和"cn.lu.learn.mapper.UserMapper.queryByUuid"都缓存了
            user = sqlSession.selectOne("queryByUuid", userUuid);

            // 第二种方法，MappedStatement ms = this.configuration.getMappedStatement(statement);
            user = sqlSession.selectOne("cn.lu.learn.mapper.UserMapper.queryByUuid", userUuid);

            // 常用方法
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.queryByUuid(userUuid);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }

        return null;
    }

    private SqlSessionFactory getSqlSessionFactory() {
        InputStream inputStream = null;
        try {
            if (null != sqlSessionFactory) {
                return sqlSessionFactory;
            }
            inputStream = Resources.getResourceAsStream("mybatis_config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        }

        return sqlSessionFactory;
    }
}
