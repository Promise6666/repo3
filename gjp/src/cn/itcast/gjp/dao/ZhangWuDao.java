package cn.itcast.gjp.dao;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
    实现对数据表gjp_zhangwu 数据增删改查操作
    dbutils工具类完成，类成员创建QueryRunner对象，指定数据源
*/
public class ZhangWuDao
{
    private QueryRunner qr = new QueryRunner(new JDBCUtils().getDataSource());
    /*
    *   定义方法，查询数据库，获取所有的账务数据
    *   方法被业务层调用
    *   结果集，把所有的账务数据，存储到Bean对象中，存储到集合
    */
    public List<ZhangWu> selectAll()
    {
        try
        {
            //查询账务数据的SQL语句
            String sql = "SELECT * FROM gjp_zhangwu";
            //调用qr对象的方法，query方法，结果集BeanListHandler
            List<ZhangWu> list = qr.query(sql,new BeanListHandler<>(ZhangWu.class));
            return list;
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
            throw new RuntimeException("查询所有账务失败");
        }
    }



    /*
    *   定义方法，查询数据库，带有条件去查询账务表
    *   被业务层调用，查询结果集存储到Bean对象，存储到List集合
    *   调用者传递两个日期字符串
    */
    public List<ZhangWu> select(String startDate,String endDate)
    {
        try
        {
            //拼写条件查询的SQL语句
            String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
            //定义对象数组，存储？占位符
            Object[] params = {startDate,endDate};
            //调用qr对象的方法query查询数据表，获取结果集
            List<ZhangWu> list = qr.query(sql,new BeanListHandler<>(ZhangWu.class),params);
            return list;
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
            throw new RuntimeException("查询部分账务失败");
        }
    }



    /*
     *  定义方法，实现账务添加功能
     *  被业务层调用，传递ZhangWu对象
     *  把ZhangWu对象中的数据，添加到账务表
     */
    public void addZhangWu(ZhangWu zw)
    {
        try
        {
            //添加数据的SQL
            String sql = "INSERT INTO gjp_zhangwu(flname,money,Zhanghu,createtime,description) VALUES(?,?,?,?,?)";
            //创建对象数组，存储5个占位符的实际参数
            //实际参数的来源是，传递过来的对象ZhangWu
            Object[] param = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
            qr.update(sql,param);
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
            throw new RuntimeException("账务添加失败");
        }
    }





    /*
     *  定义方法，实现账务编辑功能
     *  被业务层调用，传递ZhangWu对象
     *  把ZhangWu对象中的数据，更新到数据表
     */
    public void editZhangWu(ZhangWu zw)
    {
        try
        {
            //更新数据的SQL语句
            String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            qr.update(sql,params);
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
            throw new RuntimeException("编辑账务失败");
        }
    }





    /*
     *  定义方法，实现账务删除功能
     *  被业务层调用，传递int类型主键id
     */
    public void deletZhangWu(int zwid)
    {
        try
        {
            String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
            qr.update(sql,zwid);
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
            throw new RuntimeException("账务删除失败");
        }
    }
}
