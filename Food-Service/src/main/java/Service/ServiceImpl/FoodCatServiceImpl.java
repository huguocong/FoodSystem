package Service.ServiceImpl;

import mapper.FoodcatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Service.FoodCatService;
import pojo.Foodcat;
import pojo.FoodcatExample;

import java.util.List;

@Service
public class FoodCatServiceImpl implements FoodCatService {

    @Autowired
    private FoodcatMapper foodcatMapper;


    @Override
    public List<Foodcat> Find(Integer parentid) {
        FoodcatExample example = new FoodcatExample();
        FoodcatExample.Criteria criteria = example.createCriteria();
        parentid=parentid==null? 0:parentid;
        if (parentid!=null) {
            criteria.andParentIdEqualTo(parentid);
        }
        List<Foodcat> foodcats = foodcatMapper.selectByExample(example);
        return foodcats;
    }

    @Override
    public void Delete(Integer id) {
        FoodcatExample foodcatExample = new FoodcatExample();
        FoodcatExample.Criteria criteria = foodcatExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<Foodcat> foodcats = foodcatMapper.selectByExample(foodcatExample);
        //如果是一级目录，需要删除下属所有目录
        if (foodcats.size()>0) {
            for (Foodcat x : foodcats
            ) {
                foodcatMapper.deleteByPrimaryKey(x.getId());
            }
        }
        foodcatMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Foodcat FindOne(Integer id) {
        return foodcatMapper.selectByPrimaryKey(id);
    }

    @Override
    public void Save(Foodcat foodcat) {
        foodcatMapper.insert(foodcat);
    }

    @Override
    public void Updata(Foodcat foodcat) {
        foodcatMapper.updateByPrimaryKeySelective(foodcat);
    }

    @Override
    public List<Foodcat> FindAll() {
        return foodcatMapper.selectByExample(null);
    }


}
