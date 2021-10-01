package cn.itcast.gjp.controller;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

import java.util.List;

/*
     控制器层
     接收视图层的数据，数据传递给service层
     成员位置，创建service对象
*/
public class ZhangWuController
{
    private ZhangWuService service = new ZhangWuService();
    /*
    *   控制层定义方法，实现查询所有的账务数据
    *   方法由视图层调用，方法调用Service层
    */
    public List<ZhangWu> selectAll()
    {
        return service.selectAll();
    }

    /*
    *   定义方法，实现条件查询账务
    *   方法被视图层调用，传递两个日期的字符串
    *   调用Service层的方法，传递两个日期字符串，获取结果集
    *   结果集返回给视图层
    */
    public List<ZhangWu> select(String startDate,String endDate)
    {
        return service.select(startDate,endDate);
    }




    /*
     *  定义方法，实现账务添加功能
     *  被视图层调用，传递参数（传递过来的参数不能是5个数据，传递的是1个ZhangWu类型的对象）
     *  方法调用service层的方法，传递ZhangWu对象，获取到添加后的结果集(添加成功的行数，int)
     */
    public void addZhangWu(ZhangWu zw)
    {
        service.addZhangWu(zw);
    }




    /*
     *  定义方法，实现账务编辑功能
     *  被视图层调用，传递参数，也就是ZhangWu对象
     *  方法调用service层的方法，传递ZhangWu对象
     */
    public void editZhangWu(ZhangWu zw)
    {
        service.editZhangWu(zw);
    }




    /*
     *  定义方法，实现账务删除功能
     *  被视图层调用，传递int类型主键
     *  调用service层的方法，传递int类型主键
     */
    public void deletZhangWu(int zwid)
    {
        service.deletZhangWu(zwid);
    }
}
