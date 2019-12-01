package Service;

import My.PageResult;
import pojo.Food;

import java.util.List;

public interface FoodService {

    public List<Food>FindAll();

    public PageResult Search(String foodname,Integer foodcat,Integer cunt,Integer size);

    public void Save(Food food);

    public void Delete(Integer id);

    public void Update(Food food);

    public Food FindOne(Integer id);

    //推荐
    public List<Food> FindTui();

    //最新
    public List<Food> FindNew();

    public PageResult CaiDan(Integer cunt,Integer size,Integer cat1,Integer cat2);
}
