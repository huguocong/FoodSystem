package pojo;

public class Orderdetail {
    private Integer id;

    private Integer orderid;

    private Integer foodId;

    private Integer foodcount;

    private Double count;

    private Orders orders;

    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodcount() {
        return foodcount;
    }

    public void setFoodcount(Integer foodcount) {
        this.foodcount = foodcount;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", foodId=" + foodId +
                ", foodcount=" + foodcount +
                ", count=" + count +
                ", orders=" + orders +
                ", food=" + food +
                '}';
    }
}