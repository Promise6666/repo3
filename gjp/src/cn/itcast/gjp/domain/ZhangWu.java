package cn.itcast.gjp.domain;

public class ZhangWu
{
    private int zwid;
    private String flname;
    private Double money;
    private String zhanghu;
    private String createtime;
    private String description;
    public ZhangWu(){ }
    public ZhangWu(int zwid, String flname, Double money, String zhanghu, String createtime, String description)
    {
        this.zwid = zwid;
        this.flname = flname;
        this.money = money;
        this.zhanghu = zhanghu;
        this.createtime = createtime;
        this.description = description;
    }
    public void setZwid(int zwid)
    {
        this.zwid = zwid;
    }
    public int getZwid()
    {
        return zwid;
    }

    public void setFlname(String flname)
    {
        this.flname = flname;
    }
    public String getFlname()
    {
        return flname;
    }

    public void setMoney(Double money)
    {
        this.money = money;
    }
    public Double getMoney()
    {
        return money;
    }

    public void setZhanghu(String zhanghu)
    {
        this.zhanghu = zhanghu;
    }
    public String getZhanghu()
    {
        return zhanghu;
    }

    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }
    public String getCreatetime()
    {
        return createtime;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return "ZhangWu[zwid"+zwid+",flname="+flname+",money="+money+",zhanghu="+ zhanghu+",createtime="+createtime+",description="+description+"]";
    }
}
