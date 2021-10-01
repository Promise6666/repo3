package cn.itcast.gjp.tools;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/*
    获取数据库连接的工具类
    实现连接池，dbcp连接池
*/
public class JDBCUtils
{
    //创建BasicDataSource对象
    private static BasicDataSource datasource = new BasicDataSource();
    static
    {
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
        datasource.setUsername("root");
        datasource.setPassword("root");
        datasource.setMaxActive(10);
        datasource.setMaxIdle(5);
        datasource.setMinIdle(2);
        datasource.setInitialSize(10);
    }
    public static DataSource getDataSource()
    {
        return datasource;
    }
}
