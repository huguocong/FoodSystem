package My;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Double Total;
    private Map<Integer ,CartItem> map=new HashMap();//key为food主键，

    public Double getTotal() {
        Total=0.0;
        Collection<CartItem> values = map.values();
        for (CartItem x:values
             ) {
            Total+=x.getCount();
        }
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Total=" + Total +
                ", map=" + map +
                '}';
    }

    public void addcart(CartItem cartItem){
        //检查购物车是否存在该购物项
        Integer id = cartItem.getFood().getId();
        //之前购物车存在该商品
        if (map.containsKey(id)){
            CartItem oldcartem = map.get(id);
            oldcartem.setNum(cartItem.getNum()+oldcartem.getNum());
            oldcartem.setCount(cartItem.getCount()+oldcartem.getCount());
        }else {
            map.put(id,cartItem);
        }
    }

    //数量设置
    public void addandres(Integer id,Integer num){
        CartItem cartItem = map.get(id);
        cartItem.setNum(num);
        cartItem.setCount(cartItem.getFood().getPrice()*num);
    }

    //删除商品
    public void delete(Integer id){
        map.remove(id);
    }

    //清空
    public void clear(){
        map.clear();
    }


}
