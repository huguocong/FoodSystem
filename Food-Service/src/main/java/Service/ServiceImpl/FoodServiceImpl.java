package Service.ServiceImpl;

import My.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Service.FoodService;
import pojo.Food;
import pojo.FoodExample;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> FindAll() {
        return foodMapper.selectByExample(null);
    }

    @Override
    public PageResult Search(String foodname,Integer foodcat, Integer cunt, Integer size) {
        cunt=cunt==null?1:cunt;
        size=size==null?20:size;
        FoodExample example = new FoodExample();
        FoodExample.Criteria criteria = example.createCriteria();
        if (foodname!=null&&foodname.length()>0){
            criteria.andFoodnameLike("%"+foodname+"%");
        }
        if (foodcat!=null){
            criteria.andFoodtypeId1EqualTo(foodcat);
        }
        example.setOrderByClause("id desc");
        PageHelper.startPage(cunt,size);
        Page<Food> page=(Page<Food>)foodMapper.selectByExample(example);
        return new PageResult(page.getTotal(),size.longValue(),cunt.longValue(),
                page.getTotal()%size==0?page.getTotal()/size:page.getTotal()/size+1,page.getResult());
    }

    @Override
    public void Save(Food food) {
        foodMapper.insert(food);
    }

    @Override
    public void Delete(Integer id) {
        foodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void Update(Food food) {
        foodMapper.updateByPrimaryKey(food);
    }

    @Override
    public Food FindOne(Integer id) {
        return foodMapper.selectByPrimaryKey(id);
    }

    //////

    @Override
    public List<Food> FindTui() {
        FoodExample example = new FoodExample();
        FoodExample.Criteria criteria = example.createCriteria();
        criteria.andIstuijianEqualTo(0);
        return foodMapper.selectByExample1(example);
    }

    @Override
    public List<Food> FindNew() {
        FoodExample example = new FoodExample();
        example.setOrderByClause("id desc");
        return foodMapper.selectByExample1(example);
    }

    @Override
    public PageResult CaiDan(Integer cunt,Integer size, Integer cat1, Integer cat2) {
        cunt=cunt==null?1:cunt;
        size=size==null?20:size;
        FoodExample example = new FoodExample();
        FoodExample.Criteria criteria = example.createCriteria();
        if (cat1!=null){
            criteria.andFoodtypeId1EqualTo(cat1);
        }
        if (cat2!=null){
            criteria.andFoodtypeId2EqualTo(cat2);
        }
        example.setOrderByClause("id desc");
        PageHelper.startPage(cunt,20);
        Page<Food> page=(Page<Food>)foodMapper.selectByExample(example);
        return new PageResult(page.getTotal(),size.longValue(),cunt.longValue(),
                page.getTotal()%size==0?page.getTotal()/size:page.getTotal()/size+1,page.getResult());
    }
}
