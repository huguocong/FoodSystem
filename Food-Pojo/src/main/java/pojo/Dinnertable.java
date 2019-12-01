package pojo;

import java.util.Date;

public class Dinnertable {
    private Integer id;

    private String tablename;

    private Integer tablestatus;

    private Date orderdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getTablestatus() {
        return tablestatus;
    }

    public void setTablestatus(Integer tablestatus) {
        this.tablestatus = tablestatus;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @Override
    public String toString() {
        return "Dinnertable{" +
                "id=" + id +
                ", tablename='" + tablename + '\'' +
                ", tablestatus=" + tablestatus +
                ", orderdate=" + orderdate +
                '}';
    }
}