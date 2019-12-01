package Service;

import My.PageResult;
import pojo.Dinnertable;

import java.util.List;

public interface DinnerTableService {

    public List<Dinnertable> FindAll();

    public Dinnertable FindOne(Integer id);

    public PageResult Search(String dinnertablename,Integer cunt,Integer size);

    public void Save(Dinnertable dinnertable);

    public void Delete(Integer id);

    public void Update(Dinnertable dinnertable);

    public void TuiZhuo(Integer id);

    //选择未预定的餐桌
    public List<Dinnertable> list();
}
