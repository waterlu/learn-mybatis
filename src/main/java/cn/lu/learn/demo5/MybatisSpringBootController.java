package cn.lu.learn.demo5;

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
 * 终于 Mybatis + Spring Boot
 * org.mybatis.spring.boot:mybatis-spring-boot-starter:1.1.1
 *
 *
 * @author lutiehua
 * @date 2018/1/9
 */
@RestController
@RequestMapping("mybatis/spring/boot")
public class MybatisSpringBootController {

    private final Logger logger = LoggerFactory.getLogger(MybatisSpringBootController.class);

    // Application的@MapperScan注解设置了从哪个目录扫描
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
