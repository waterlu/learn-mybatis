package cn.lu.learn.dao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
public interface KingoldBaseMapper<T> extends Mapper<T> {

    /**
     * 逻辑删除
     *
     * @param key
     * @return
     */
    @DeleteProvider(type = KingoldMyBatisProvider.class, method = "dynamicSQL")
    int deleteById(Object key);

    /**
     * 读取时判断删除标志位
     *
     * @param key
     * @return
     */
    @SelectProvider(type = KingoldMyBatisProvider.class, method = "dynamicSQL")
    T selectById(Object key);

}