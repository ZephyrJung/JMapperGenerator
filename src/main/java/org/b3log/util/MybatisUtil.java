package org.b3log.util;

import org.apache.ibatis.session.SqlSession;
import org.b3log.model.MapperInfo;
import org.b3log.model.TableColumn;
import org.b3log.mybatis.MySqlMapper;
import org.b3log.mybatis.config.MybatisConfig;

import java.util.List;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class MybatisUtil {
    private static final String driver = "com.mysql.jdbc.Driver";
    public static boolean generate(MapperInfo mapperInfo) {
        if (!mapperInfo.checkParam()) {
            return false;
        }
        SqlSession session = MybatisConfig.getSqlSessionFactory(driver, mapperInfo.getUrl(), mapperInfo.getUserName(), mapperInfo.getPassword()).openSession();
        MySqlMapper mapper = session.getMapper(MySqlMapper.class);
        List<String> tableList = mapper.showTables();
        for (String table : tableList) {
            List<TableColumn> columnList = mapper.getTableColumns(table, mapperInfo.getDatabase());
            FileUtil.writeMapperXml(StringUtil.CamelToUpperCase(table), MapperXmlUtil.generateMapperXml(mapperInfo.getMapperJavaPack(), StringUtil.CamelToUpperCase(table), columnList));
            FileUtil.writeMapperJava(StringUtil.CamelToUpperCase(table), MapperJavaUtil.generateMapperJava(mapperInfo.getMapperJavaPack(), StringUtil.CamelToUpperCase(table)));
            FileUtil.writeModel(StringUtil.CamelToUpperCase(table), ModelCodeUtil.generateModel(mapperInfo.getModelPack(), StringUtil.CamelToUpperCase(table), columnList));
        }
        session.close();
        return true;
    }
}
