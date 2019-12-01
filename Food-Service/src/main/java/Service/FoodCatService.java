package Service;

import pojo.Foodcat;

import java.util.List;

public interface FoodCatService {

    //查找所有分类
    public List<Foodcat> FindAll();

    //父类目查找子类目
    public List<Foodcat> Find(Integer parentid);

    public void Delete(Integer id);

    public Foodcat FindOne(Integer id);

    public void Save(Foodcat foodcat);

    public void Updata(Foodcat foodcat);



}
