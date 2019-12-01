package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    private String orderId;

    private Integer tableId;

    private Date orderdate;

    private Double totalprice;

    private Integer orderstatus;

    private String people;

    private String tele;

    private Integer userId;

    private Dinnertable dinnertable;

    private User user;

    private List<Orderdetail> list=new ArrayList<>();

    public List<Orderdetail> getList() {
        return list;
    }

    public void setList(List<Orderdetail> list) {
        this.list = list;
    }

    public Dinnertable getDinnertable() {
        return dinnertable;
    }

    public void setDinnertable(Dinnertable dinnertable) {
        this.dinnertable = dinnertable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people == null ? null : people.trim();
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele == null ? null : tele.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", tableId=" + tableId +
                ", orderdate=" + orderdate +
                ", totalprice=" + totalprice +
                ", orderstatus=" + orderstatus +
                ", people='" + people + '\'' +
                ", tele='" + tele + '\'' +
                ", userId=" + userId +
                ", dinnertable=" + dinnertable +
                ", user=" + user +
                ", list=" + list +
                '}';
    }
}