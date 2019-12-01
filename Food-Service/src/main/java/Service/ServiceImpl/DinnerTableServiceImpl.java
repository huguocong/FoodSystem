package Service.ServiceImpl;

import My.PageResult;
import Service.DinnerTableService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.DinnertableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Dinnertable;
import pojo.DinnertableExample;

import java.util.List;

@Service
public class DinnerTableServiceImpl implements DinnerTableService {

    @Autowired
    private DinnertableMapper dinnertableMapper;

    @Override
    public List<Dinnertable> FindAll() {
        return dinnertableMapper.selectByExample(null);
    }

    @Override
    public PageResult Search(String dinnertablename, Integer cunt, Integer size) {
        Integer c=cunt==null?1:cunt;
        Integer s=size==null?5:size;
        PageHelper.startPage(c,s);
        DinnertableExample example = new DinnertableExample();
        DinnertableExample.Criteria criteria = example.createCriteria();
        if (dinnertablename!=null&&dinnertablename.length()>0) {
            criteria.andTablenameEqualTo(dinnertablename);
        }
        Page<Dinnertable> page=(Page<Dinnertable>)dinnertableMapper.selectByExample(example);
        return new PageResult(page.getTotal(),s.longValue(),c.longValue(),page.getTotal()%s==0?page.getTotal()/s:page.getTotal()/s+1,
                page.getResult());
    }

    @Override
    public void Save(Dinnertable dinnertable) {
        dinnertable.setTablestatus(0);
        dinnertableMapper.insert(dinnertable);
    }

    @Override
    public Dinnertable FindOne(Integer id) {
        return dinnertableMapper.selectByPrimaryKey(id);
    }

    @Override
    public void Delete(Integer id) {
        dinnertableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void Update(Dinnertable dinnertable) {
        dinnertableMapper.updateByPrimaryKey(dinnertable);
    }

    @Override
    public void TuiZhuo(Integer id) {
        dinnertableMapper.tuizhuo(id);
    }

    @Override
    public List<Dinnertable> list() {
        DinnertableExample example = new DinnertableExample();
        DinnertableExample.Criteria criteria = example.createCriteria();
        criteria.andTablestatusEqualTo(0);
        return dinnertableMapper.selectByExample(example);
    }
}
