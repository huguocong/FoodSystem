package Service.ServiceImpl;

import My.PageResult;
import Service.OrdersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.OrderdetailMapper;
import mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.*;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> FindAll() {
        return ordersMapper.selectByExample(null);
    }

    @Override
    public PageResult Search(String OrdersId, Integer cunt, Integer size) {
        cunt=cunt==null?1:cunt;
        size=size==null?5:size;
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        if (OrdersId!=null&&OrdersId.length()>0){
            criteria.andOrderIdLike("%"+OrdersId+"%");
        }
        example.setOrderByClause("id desc");
        PageHelper.startPage(cunt,size);
        Page<Orders> page=(Page<Orders>)ordersMapper.selectByExample(example);
        return new PageResult(page.getTotal(),size.longValue(),cunt.longValue(),
                page.getTotal()%size==0?page.getTotal()/size:page.getTotal()/size+1,page.getResult());
    }

    @Override
    public Orders FindOne(Integer id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public List<Orderdetail> Find(Integer Orderdetail_id) {
        OrderdetailExample example = new OrderdetailExample();
        OrderdetailExample.Criteria criteria = example.createCriteria();
        if (Orderdetail_id!=null){
            criteria.andOrderidEqualTo(Orderdetail_id);
        }
        List<Orderdetail> orderdetails = orderdetailMapper.selectByExample(example);
        return orderdetails;
    }

    //根据餐桌id查找订单
    @Override
    public Orders FindCan(Integer id) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        if (id!=null){
            criteria.andTableIdEqualTo(id);
            criteria.andOrderstatusEqualTo(1);
        }
       Orders s=null;
        List<Orders> orders = ordersMapper.selectByExample(example);
        if (orders.size()>0){
            s=orders.get(0);
        }
        return s;
    }

    //更新订单为已完成
    @Override
    public void Updata(Orders orders) {
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public int Insertid(Orders orders) {
        return  ordersMapper.insert1(orders);
    }

    //插入详情
    @Override
    public void InsertOrderdetail(Orderdetail orderdetail) {
        orderdetailMapper.insert(orderdetail);
    }

    @Override
    public PageResult Search1(Integer userid, String OrdersId, Integer cunt,Integer size){
        cunt=cunt==null?1:cunt;
        size=size==null?5:size;
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        if (OrdersId!=null&&OrdersId.length()>0){
            criteria.andOrderIdLike("%"+OrdersId+"%");
        }
            criteria.andUserIdEqualTo(userid);
        example.setOrderByClause("id desc");
        PageHelper.startPage(cunt,size);
        Page<Orders> page=(Page<Orders>)ordersMapper.selectByExample(example);
        return new PageResult(page.getTotal(),size.longValue(),cunt.longValue(),
                page.getTotal()%size==0?page.getTotal()/size:page.getTotal()/size+1,page.getResult());
    }

    @Override
    public void Delete(Integer id) {
        ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void UpdataNew(Orders orders) {
        ordersMapper.updateByPrimaryKeySelective(orders);
    }
}
