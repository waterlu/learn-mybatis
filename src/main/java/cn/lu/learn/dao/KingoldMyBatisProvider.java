package cn.lu.learn.dao;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * @author lutiehua
 * @date 2018/1/22
 */
public class KingoldMyBatisProvider extends MapperTemplate {

    public KingoldMyBatisProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String selectById(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //将返回值修改为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(KingoldSqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }

    public String deleteById(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append("<set>");
        sql.append("delete_flag = 1");
        sql.append("</set>");
        sql.append(SqlHelper.wherePKColumns(entityClass));
        return sql.toString();
    }
}
