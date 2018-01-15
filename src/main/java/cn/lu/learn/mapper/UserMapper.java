package cn.lu.learn.mapper;

import cn.lu.learn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lutiehua
 * @date 2018/1/5
 */
@Repository
//@Mapper
//@MapperScan(basePackages = {"cn.lu.learn.mapper"})
public interface UserMapper {

    User queryByUuid(String userUuid);

}