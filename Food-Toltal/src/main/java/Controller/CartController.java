package Controller;

import My.Cart;
import My.CartItem;
import My.Result;
import Service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Food;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("Cart")
public class CartController {

    @Resource
    private FoodService foodService;

    @RequestMapping("index")
    public String Index(){
        return "jsp/cart";
    }

    @RequestMapping("Add")
    @ResponseBody
    public Result Add(HttpServletRequest request, Integer id, Integer num){
        try {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            //如果购物车为空，新增购物车
            if (cart==null){
                cart = new Cart();
                request.getSession().setAttribute("cart",cart);
            }
            //根据id查询food
            Food food = foodService.FindOne(id);
            CartItem cartItem = new CartItem();
            cartItem.setNum(num);
            cartItem.setFood(food);
            cartItem.setCount(food.getPrice()*num);
            //添加购物项到购物车
            cart.addcart(cartItem);
            cart.setTotal(cart.getTotal());
            return new Result(true,"成功添加到列表");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    //数量增减
    @RequestMapping("Yun")
    public String sunandres(HttpServletRequest request,Integer id,Integer num){
        //获取到购物车
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        cart.addandres(id,num);
        return "jsp/cart";
    }

    //清空购物车
    @RequestMapping("Clear")
    public String Clear(HttpServletRequest request){
        //获取到购物车
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        cart.clear();
        request.getSession().removeAttribute("cart");
        return "jsp/cart";
    }

    //删除商品
    @RequestMapping("Delete")
    public String Delete(HttpServletRequest request,Integer id){
        //获取到购物车
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        cart.delete(id);
        Map<Integer, CartItem> map = cart.getMap();
        if(map.size()<1){
            request.getSession().invalidate();
        }
        return "jsp/cart";
    }
}
