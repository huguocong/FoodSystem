package Controller;

import My.Cart;
import My.CartItem;
import My.PageResult;
import My.Result;
import Service.DinnerTableService;
import Service.FoodService;
import Service.OrdersService;
import Service.UserService;
import Utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Order")
public class OrderController {

    @Resource
    private OrdersService ordersService;

    @Resource
    private FoodService foodService;

    @Resource
    private UserService userService;



    @RequestMapping("JieSuan")
    public String JieSuan(HttpServletRequest request){
        //获取用户
        Integer userid=(Integer) request.getSession().getAttribute("uuserid");
        if (userid!=null) {
            //获取购物车
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart!=null) {
                Orders orders = new Orders();
                orders.setUserId(userid);
                orders.setOrderId(UUIDUtils.getCode());
                orders.setOrderdate(new Date());
                orders.setTotalprice(cart.getTotal());
                orders.setOrderstatus(0);
                //插入订单返回主键id
                ordersService.Insertid(orders);
                Integer insertid = orders.getId();

                //加入用户
                User user = userService.FindOne(userid);
                orders.setUser(user);
                for (CartItem x : cart.getMap().values()
                ) {
                    Orderdetail orderdetail = new Orderdetail();
                    //主键
                    orderdetail.setOrderid(insertid);
                    orderdetail.setFoodId(x.getFood().getId());
                    orderdetail.setFoodcount(x.getNum());
                    orderdetail.setCount(x.getCount());
                    //插入订单详细
                    ordersService.InsertOrderdetail(orderdetail);
                    //设置订单，食物
                    orderdetail.setOrders(orders);
                    orderdetail.setFood(x.getFood());
                    orders.getList().add(orderdetail);
                }
                //清空购物车
                cart.clear();
                request.getSession().removeAttribute("cart");
                request.getSession().setAttribute("order", orders);
            }
        }
        return "jsp/order";
    }

    //订单界面预订
    @RequestMapping("ToJieSuan")
    public String ToJieSuan(HttpServletRequest request,Integer id){
        Orders orders = ordersService.FindOne(id);
        //查找订单详情
        List<Orderdetail> orderdetails = ordersService.Find(orders.getId());
        for (Orderdetail x:orderdetails
             ) {
            Food food = foodService.FindOne(x.getFoodId());
            x.setFood(food);
        }
        orders.setList(orderdetails);
        request.getSession().setAttribute("order", orders);
        return "jsp/order";
    }


    @Resource
    private DinnerTableService dinnerTableService;
    //选择未预定的餐桌
    @RequestMapping("Zhuo")
    @ResponseBody
    public List<Dinnertable> list(){
        return dinnerTableService.list();
    }

    //预定
    @RequestMapping("YuDing")
    @ResponseBody
    public Result YuDing(HttpServletRequest request, HttpServletResponse response, Integer id, Integer tableid, String people, String tele){
        try {
            //查找到餐桌
            Dinnertable dinnertable = dinnerTableService.FindOne(tableid);
            Orders orders = ordersService.FindOne(id);
            orders.setPeople(people);
            orders.setTele(tele);
            orders.setTableId(dinnertable.getId());
            orders.setOrderstatus(1);
            ordersService.UpdataNew(orders);

            //更新餐桌为已预订
            dinnertable.setTablestatus(1);
            dinnertable.setOrderdate(new Date());
            dinnerTableService.Update(dinnertable);
            return new Result(true,"预订成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"预订失败");
        }

    }

    @RequestMapping("Search")
    public String Search(HttpServletRequest request,String id,Integer cunt,Integer size){
        Integer userid=(Integer)request.getSession().getAttribute("uuserid");
        PageResult pageResult = ordersService.Search1(userid, id, cunt, size);
        List<Orders>orders=pageResult.getRow();
        if (orders.size()>0) {
            //遍历所有订单
            for (Orders x : orders
            ) {
                //查找到所有订单详情
                List<Orderdetail> orderdetails = ordersService.Find(x.getId());
                for (Orderdetail s : orderdetails
                ) {
                    Food food = foodService.FindOne(s.getFoodId());
                    s.setFood(food);
                }
                x.setList(orderdetails);
            }
            request.getSession().setAttribute("orders", pageResult);
        }
     return "jsp/myorder";
    }

    @RequestMapping("Delete")
    @ResponseBody
    public Result Delete(Integer id){
        try {
            ordersService.Delete(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
