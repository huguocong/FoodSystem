package test;

import Service.FoodCatService;
import mapper.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class x {

    public static void a(String name){
        System.out.println(name);
    }

    @Test
    public void ssss(){
        ApplicationContext x=new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        OrdersMapper bean = x.getBean(OrdersMapper.class);
        Orders orders = new Orders();
        orders.setTotalprice(12.3);
        int i = bean.insert1(orders);
        System.out.println(orders.getId());
    }


    @Test
    public void ss(){
        ApplicationContext x=new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        FoodCatService bean = x.getBean(FoodCatService.class);
        List<Map> list=new ArrayList<>();
        Map map=new HashMap();
        List<Foodcat> parent = bean.Find(0);
        for (Foodcat xs:parent
             ) {
            List<Foodcat> son = bean.Find(xs.getId());
            map.put("parent",xs);
            map.put("son",son);
            map.clear();
            System.out.println("1");
        }
        for (Map t:list
             ) {
            for (Object k:t.keySet()
                 ) {
                System.out.println(k);

            }

        }
    }

    @Test
    public  void te(){
        ApplicationContext x=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        FoodcatMapper foodcatMapper = x.getBean(FoodcatMapper.class);
    }

}
