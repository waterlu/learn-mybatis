package cn.lu.learn.dao;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;

import java.util.Set;

/**
 * @author lutiehua
 * @date 2018/1/22
 */
public class KingoldSqlHelper {

    public static String wherePKColumns(Class<?> entityClass) {
        StringBuilder sql = new StringBuilder();
        sql.append("<where>");
        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entityClass);
        //当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (EntityColumn column : columnList) {
            sql.append(" AND " + column.getColumnEqualsHolder());
        }
        sql.append(" AND delete_flag = 0");
        sql.append("</where>");
        return sql.toString();
    }
}