package Controller;

import My.Result;
import Service.FoodCatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Foodcat;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("AdminFoodCat")
public class AdminFoodCatController {

    @Resource
    private FoodCatService foodCatService;

    @RequestMapping("Find")
    public String Find(Model model, Integer parentID,String name){
        List<Foodcat> find = foodCatService.Find(parentID);
        model.addAttribute("FoodCat",find);
        model.addAttribute("parentname",name);
        model.addAttribute("parentid",parentID);
        return "admin/jsp/FoodCat";
    }

    @RequestMapping("Delete")
    @ResponseBody
    public Result Delete(Integer id){
        try {
            foodCatService.Delete(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("ToSave")
    public String ToSave(Model model,Integer id,Integer name){
        if (name==0){
            //新建
            model.addAttribute("foodcatparenidinput",id==null?0:id);
        }else if (name==1){
            //更新
            Foodcat foodcat = foodCatService.FindOne(id);
            model.addAttribute("foodcatinput",foodcat);
        }
        return "admin/jsp/FoodCatSave";
    }

    @RequestMapping("Save")
    @ResponseBody
    public Result Save(@RequestBody Foodcat foodcat){
        try {
            foodCatService.Save(foodcat);
            return new Result(true,"保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"保存失败");
        }
    }

    @RequestMapping("Updata")
    @ResponseBody
    public Result Updata(@RequestBody Foodcat foodcat){
        try {
            foodCatService.Updata(foodcat);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");
        }
    }

    //根据一级选择二级
    @RequestMapping("OneToTwo")
    @ResponseBody
    public List<Foodcat> OneToTwo(Integer id){
        return foodCatService.Find(id);
    }
}
