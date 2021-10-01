package cn.itcast.gjp.service;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

import java.util.List;

/*
    业务层类
    接收上一层，控制层controller的数据
    经过计算，传递给dao层，操作数据库
    调用dao层中的类，类成员位置，创建Dao类的对象
*/
public class ZhangWuService
{
    private ZhangWuDao dao = new ZhangWuDao();
    /*
    *   实现方法，实现查询所有的账务数据
    *   此方法由控制层调用，去调用dao层的方法
    */
    public List<ZhangWu> selectAll()
    {
        return dao.selectAll();
    }


    /*
    *   定义方法，实现条件查询服务
    *   方法被控制层调用，传递两个日期字符串
    *   调用dao层的方法，传递两个日期字符串
    *   获取查询结果集
    */
    public List<ZhangWu> select(String startDate,String endDate)
    {
        return dao.select(startDate,endDate);
    }



    /*
     *  定义方法，实现账务添加功能
     *  被控制层调用，传递ZhangWu类型对象
     *  方法调用dao层的方法，传递ZhangWu对象
     */
    public void addZhangWu(ZhangWu zw)
    {
        dao.addZhangWu(zw);
    }




    /*
     *  定义方法，实现账务编辑功能
     *  被控制层调用，传递ZhangWu类型对象
     *  方法调用dao层的方法，传递ZhangWu对象
     */
    public void editZhangWu(ZhangWu zw)
    {
        dao.editZhangWu(zw);
    }





    /*
     *  定义方法，实现账务删除功能
     *  被控制层调用，传递int类型主键
     *  调用dao层的方法，传递int类型主键
     */
    public void deletZhangWu(int zwid)
    {
        dao.deletZhangWu(zwid);
    }
}
