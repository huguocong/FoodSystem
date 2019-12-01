package Controller;

import My.PageResult;
import Service.DinnerTableService;
import Service.FoodService;
import Service.OrdersService;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("AdminOrders")
public class AdminOrdersController {

    @Resource
    private OrdersService ordersService;

    @Resource
    private DinnerTableService dinnerTableService;

    @Resource
    private UserService userService;

    @Resource
    private FoodService foodService;

    @RequestMapping("Search")
    public String Search(Model model, String orderid, Integer Cunt, Integer Size){
        PageResult search = ordersService.Search(orderid, Cunt, Size);

        //订单拼接user，餐桌
        List<Orders>orders=search.getRow();
        for (Orders x:orders
        ) {
            x.setDinnertable(dinnerTableService.FindOne(x.getTableId()));
            x.setUser(userService.FindOne(x.getUserId()));
        }
        model.addAttribute("Orders",search);
        model.addAttribute("orderid",orderid);
        return "admin/jsp/Orders";
    }

    @RequestMapping("Orderdetail")
    public String Orderdetail(Model model,Integer id){
        List<Orderdetail> find = ordersService.Find(id);
        List<Food> foods = foodService.FindAll();
        List<Orders> orders = ordersService.FindAll();
        for (Orderdetail x:find
        ) {
            x.setFood(foods.get(x.getFoodId()));
            x.setOrders(orders.get(x.getOrderid()));
        }
        model.addAttribute("Orderdetail",find);
        return "admin/jsp/Orderdetail";
    }



}
