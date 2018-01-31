package cn.lu.learn.demo4;

import cn.lu.learn.entity.Account;
import cn.lu.learn.entity.User;
import cn.lu.learn.mapper.AccountMapper;
import cn.lu.learn.mapper.UserMapper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * MyBatis + Spring
 * org.mybatis:mybatis-spring:1.3.0
 *
 * @author lutiehua
 * @date 2018/1/9
 */
@RestController
@RequestMapping("mybatis/spring")
public class MybatisSpringController {

    private final Logger logger = LoggerFactory.getLogger(MybatisSpringController.class);

    // 方法一：spring-mybatis.xml中定义了id为userMapper的bean，这里直接引用
    // userMapper指定了Mapper类和sqlSessionFactory
//    @Autowired
//    @Qualifier(value = "userMapper")
//    private UserMapper userMapper;

    // 方法二：spring-mybatis.xml中不用定义每个Mapper的Bean，指定目录扫描注解
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/query")
//    @Transactional
    public User query(@RequestParam String userUuid) {
        if (Strings.isNullOrEmpty(userUuid)) {
            return null;
        }

        return userMapper.queryByUuid(userUuid);
    }

    @GetMapping("/account/{accountUuid}")
    public Account getAccount(@PathVariable String accountUuid) {
//        return accountMapper.selectByPrimaryKey(accountUuid);
//        return accountMapper.selectById(accountUuid);
        return null;
    }

}
