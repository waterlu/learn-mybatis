package cn.lu.learn.demo6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lutiehua
 * @date 2018/1/9
 */
@RestController
@RequestMapping("mybatis/spring")
public class MybatisPluginController {

    private final Logger logger = LoggerFactory.getLogger(MybatisPluginController.class);

}
