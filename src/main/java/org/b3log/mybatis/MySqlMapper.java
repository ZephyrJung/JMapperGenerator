package org.b3log.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.b3log.model.TableColumn;

import java.util.List;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public interface MySqlMapper {
    @Select("show tables")
    List<String> showTables();

    @Select("select column_name,data_type,column_comment from information_schema.COLUMNS where table_name = #{tableName}  and table_schema = #{dbName}")
    List<TableColumn> getTableColumns(@Param("tableName") String tableName, @Param("dbName") String dbName);

}
