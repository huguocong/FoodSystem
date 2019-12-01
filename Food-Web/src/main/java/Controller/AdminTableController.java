package Controller;

import My.PageResult;
import My.Result;
import Service.DinnerTableService;
import Service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Dinnertable;
import pojo.Orders;

import javax.annotation.Resource;

@Controller
@RequestMapping("/AdminTable")
public class AdminTableController {

    @Resource
    private DinnerTableService dinnerTableService;

    @Resource
    private OrdersService ordersService;

    @RequestMapping("Search")
    public String Search(Model model,String DinnerTableName,Integer Cunt,Integer Size){
        PageResult search = dinnerTableService.Search(DinnerTableName, Cunt, Size);
        model.addAttribute("dinnertable",search);
        model.addAttribute("DinnerTableName",DinnerTableName);
        return "admin/jsp/DinnerTable";
    }

    @RequestMapping("Save")
    @ResponseBody
    public Result Save(@RequestBody Dinnertable dinnertable){
        try {
            dinnerTableService.Save(dinnertable);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("Delete")
    @ResponseBody
    public Result Delete(Integer id){
        try {
            dinnerTableService.Delete(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("TuiZhuo")
    @ResponseBody
    public Result TuiZhuo(Integer id){
        try {
            dinnerTableService.TuiZhuo(id);
            //查找到订单设置为完成
            Orders orders = ordersService.FindCan(id);
            orders.setOrderstatus(2);
            ordersService.Updata(orders);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");
        }
    }

    @RequestMapping("ToSave")
    public String ToSave(){
        return "admin/jsp/DinnerTableSave";
    }



}
