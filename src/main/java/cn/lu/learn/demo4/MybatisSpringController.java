package cn.lu.learn.demo4;

import cn.lu.learn.entity.User;
import cn.lu.learn.mapper.UserMapper;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/query")
    public User query(@RequestParam String userUuid) {
        if (Strings.isNullOrEmpty(userUuid)) {
            return null;
        }

        return userMapper.queryByUuid(userUuid);
    }

}
