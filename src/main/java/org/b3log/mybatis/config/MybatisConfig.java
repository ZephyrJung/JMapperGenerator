package org.b3log.mybatis.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.b3log.model.MapperInfo;
import org.b3log.mybatis.MySqlMapper;
import org.b3log.util.MybatisUtil;

import javax.sql.DataSource;

/**
 * @author Zhang Yu
 * Date: 17年12月13日
 * Email: 2895205695@qq.com
 */
public class MybatisConfig {
    public static SqlSessionFactory getSqlSessionFactory(String driver, String url, String username, String password) {
        DataSource dataSource = new PooledDataSource(driver, url, username, password);
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setMapUnderscoreToCamelCase(true);
        addMapper(configuration);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    /*public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/b3log_symphony?characterEncoding=utf-8&useSSL=true";
        String username = "root";
        String password = "root";

        MapperInfo mapperInfo = MapperInfo.builder()
                .url(url)
                .userName(username)
                .password(password)
                .database("b3log_symphony")
                .mapperJavaPack("org.b3log.zephyr.mapper")
                .modelPack("org.b3log.zephyr.model")
                .build();

        MybatisUtil.generate(mapperInfo);
    }*/

    private static void addMapper(Configuration configuration) {
        configuration.addMapper(MySqlMapper.class);
    }
}
