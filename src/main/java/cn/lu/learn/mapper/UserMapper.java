package cn.lu.learn.mapper;

import cn.lu.learn.entity.User;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
public interface UserMapper {

    User queryByUuid(String userUuid);

}