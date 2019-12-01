package Controller;

import My.PageResult;
import Service.FoodCatService;
import Service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Food;
import pojo.Foodcat;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("CaiDan")
public class CaiDanController {

    @Resource
    private FoodService foodService;

    @Resource
    private FoodCatService foodCatService;

    @RequestMapping("Search")
    public String Search(Model model,Integer cunt,Integer size,Integer cat1,Integer cat2){
        PageResult search = foodService.CaiDan(cunt,size,cat1,cat2);
        model.addAttribute("food",search);
        model.addAttribute("cat1",cat1==null?0:cat1);
        model.addAttribute("cat2",cat2==null?0:cat2);
        List<Foodcat> parent = foodCatService.Find(0);
        List<Map> list=new ArrayList<>();
        for (Foodcat x:parent
             ) {
            List<Foodcat> son = foodCatService.Find(x.getId());
            Map map=new HashMap<>();
            map.put("parent",x);
            map.put("list",son);
            list.add(map);
        }
        model.addAttribute("foodcat",list);
        return "jsp/caidan";
    }

    @RequestMapping("Desc")
    public String Desc(Model model,Integer id){
        Food food = foodService.FindOne(id);
        model.addAttribute("findfood",food);
        return "jsp/desc";
    }
}
