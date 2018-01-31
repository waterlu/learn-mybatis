package cn.lu.learn.mapper;

import cn.lu.learn.entity.Pay;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PayMapper extends Mapper<Pay> {
}