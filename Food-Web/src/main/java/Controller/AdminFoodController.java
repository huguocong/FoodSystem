package Controller;

import My.PageResult;
import My.Result;
import Service.FoodCatService;
import Service.FoodService;
import Utils.FastDFSClient;
import Utils.UploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import pojo.Food;
import pojo.Foodcat;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;


@Controller
@RequestMapping("AdminFood")
public class AdminFoodController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @Resource
    private FoodService foodService;

    @Resource
    private FoodCatService foodCatService;



    @RequestMapping("Search")
    public String Search(Model model,String foodname,Integer findfoodcat,Integer Cunt,Integer Size){
        PageResult search = foodService.Search(foodname,findfoodcat, Cunt, Size);
        List<Food>list=search.getRow();
        for (Food x:list
        ) {
            Foodcat foodcat1 = foodCatService.FindOne(x.getFoodtypeId1());
            Foodcat foodcat2 = foodCatService.FindOne(x.getFoodtypeId2());
            x.setCat1(foodcat1==null?null:foodcat1.getName());
            x.setCat2(foodcat2==null?null:foodcat2.getName());
        }
        //查找所有一级分类
        List<Foodcat> allcat = foodCatService.Find(null);
        model.addAttribute("allcat",allcat);
        model.addAttribute("Food",search);
        model.addAttribute("findfoodcat",foodCatService.FindOne(findfoodcat));//回显分类
        model.addAttribute("foodname",foodname);
        return "admin/jsp/Food";
    }

    @RequestMapping("ToSave")
    public String ToSave(Model model,Integer id){
        if (id!=null){
            //id查找到一条
            Food food = foodService.FindOne(id);
            //拼接分类
            Foodcat foodcat1 = foodCatService.FindOne(food.getFoodtypeId1());
            Foodcat foodcat2 = foodCatService.FindOne(food.getFoodtypeId2());
            food.setCat1(foodcat1==null?null:foodcat1.getName());
            food.setCat2(foodcat2==null?null:foodcat2.getName());
            model.addAttribute("FoodInput",food);
        }
        //一级目录
        List<Foodcat> find1 = foodCatService.Find(0);
        model.addAttribute("footcat1",find1);
        return "admin/jsp/FoodSave";
    }

    @RequestMapping("Delete")
    @ResponseBody
    public Result Delete(Integer id){
        try {
            foodService.Delete(id);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("Save")
    @ResponseBody
    public Result Save(@RequestBody Food food){
        try {
            foodService.Save(food);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("Updata")
    @ResponseBody
    public Result Updata(@RequestBody Food food){
        try {
            foodService.Update(food);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");
        }
    }

    @RequestMapping("Upload")
    @ResponseBody
    public String Upload(MultipartFile file )throws Exception{
        String filename = file.getOriginalFilename();
        //重命名，得到随机名
        String newName = UploadUtils.getUUIDName(filename);

        //获取绝对路径 方式一：ServletContext servletContext = request.getSession().getServletContext();
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String realPath = servletContext.getRealPath("/product/");
        //随机多级目录
        String dir=UploadUtils.getDir(newName);
        String path=realPath+dir;
        File file1 = new File(path);
        if (!file1.exists()){
            file1.mkdirs();//mkdirs需要创建多及目录
        }
        File file2 = new File(file1, newName);
        if (!file2.exists()){
            file.transferTo(file2);
        }
        System.out.println(path+newName);
        return "product"+ dir+"/"+newName;

        //文件输出流
        //获取输入流对象，获取图片二进制数据
        // InputStream inputStream = file.getInputStream();
       /* FileOutputStream outputStream = new FileOutputStream(file2);
        IOUtils.copy(inputStream,outputStream);
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);*/
    }


    @RequestMapping("UploadFD")
    @ResponseBody
    public String UploadFD(MultipartFile file)throws Exception{
        String originalFilename = file.getOriginalFilename();
        //获取拓展名
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/fdfs_client.conf");
        //上传
        String path=fastDFSClient.uploadFile(file.getBytes(),substring);
        //返回URL，ip拼接地址
        String url=FILE_SERVER_URL+path;
        return url;
    }


}
