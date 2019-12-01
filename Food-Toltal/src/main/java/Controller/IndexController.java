package Controller;

import Service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Food;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {

    @Resource
    private FoodService foodService;

    @RequestMapping("index")
    public String index(Model model){
        List<Food> new1 = foodService.FindNew();
        List<Food> tui = foodService.FindTui();
        model.addAttribute("new1",new1);
        model.addAttribute("tui",tui);
        return "index";
    }
}
