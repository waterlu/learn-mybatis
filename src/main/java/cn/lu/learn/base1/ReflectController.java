package cn.lu.learn.base1;

import cn.lu.learn.demo1.JdbcController;
import cn.lu.learn.entity.User;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
@RestController
@RequestMapping("reflect")
public class ReflectController {

    private final Logger logger = LoggerFactory.getLogger(ReflectController.class);

    @RequestMapping("/query")
    public User query(@RequestParam String userUuid) {
        if (Strings.isNullOrEmpty(userUuid)) {
            return null;
        }

        try {
//            Object jdbcController = Class.forName(JdbcController.class.getName());
//            Method method = jdbcController.getClass().getMethod("getUser", String.class);
//            Object result = method.invoke(jdbcController, userUuid);
//            return (User)result;

            Object user = Class.forName(User.class.getName());
            Method method = user.getClass().getMethod("getUserMobile");
            Object result = method.invoke(user, userUuid);
            String mobile = (String) result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return null;
    }

}