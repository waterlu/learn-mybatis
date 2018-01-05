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
 * @author lutiehua
 * @date 2018/1/5
 */
@RestController
@RequestMapping("mybatis2")
public class MybatisController2 {

    private final Logger logger = LoggerFactory.getLogger(MybatisController2.class);

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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.queryByUuid(userUuid);
            // 提交事务
            sqlSession.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            // 回滚事务
            sqlSession.rollback();
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }

        return null;
    }

    private SqlSessionFactory getSqlSessionFactory() {
        if (null != sqlSessionFactory) {
            return sqlSessionFactory;
        }

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis_config2.xml");
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
