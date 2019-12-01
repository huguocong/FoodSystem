package My;

import pojo.Food;

public class CartItem {

    private Food food;
    private Integer num;
    private Double count;

    @Override
    public String toString() {
        return "CartItem{" +
                "food=" + food +
                ", num=" + num +
                ", count=" + count +
                '}';
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }
}
