package Service;

import My.PageResult;
import pojo.Orderdetail;
import pojo.Orders;
import pojo.User;

import java.util.List;

public interface OrdersService {

    public List<Orders>FindAll();

    public Orders FindOne(Integer id);

    public PageResult Search(String OrdersId,Integer cunt,Integer size);

    public List<Orderdetail> Find(Integer Orderdetail_id);

    //根据餐桌查找订单
    public Orders FindCan(Integer id);

    //更新订单为已完成
    public void Updata(Orders orders);

    public int Insertid(Orders orders);

    //插入订单详情
    public void InsertOrderdetail(Orderdetail orderdetail);

    public PageResult Search1(Integer userid,String OrdersId,Integer cunt,Integer size);

    public void Delete(Integer id);

    public void UpdataNew(Orders orders);

}
