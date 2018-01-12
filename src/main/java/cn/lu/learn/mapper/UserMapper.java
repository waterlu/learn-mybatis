package cn.lu.learn.mapper;

import cn.lu.learn.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
@Repository
public interface UserMapper {

    User queryByUuid(String userUuid);

}