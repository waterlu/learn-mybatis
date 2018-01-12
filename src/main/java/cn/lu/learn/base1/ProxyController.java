package cn.lu.learn.base1;

import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lutiehua
 * @date 2018/1/8
 */
@RestController
@RequestMapping("proxy")
public class ProxyController {

    @RequestMapping("/query")
    public String query(@RequestParam String userUuid) {
        if (Strings.isNullOrEmpty(userUuid)) {
            return null;
        }

        UserServiceProxy userServiceProxy = new UserServiceProxy();
        UserService userService = (UserService)userServiceProxy.bind(new UserServiceImpl());

        return userService.getUserName(userUuid);
    }

}
