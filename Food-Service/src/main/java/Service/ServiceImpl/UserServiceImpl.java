package Service.ServiceImpl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Service.UserService;
import pojo.User;
import pojo.UserExample;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> FindAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User FindOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User Login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (user.getUsername()!=null&&user.getUsername().length()>0){
            criteria.andUsernameEqualTo(user.getUsername());
        }
        if (user.getPassword()!=null&&user.getPassword().length()>0){
            criteria.andPasswordEqualTo(user.getPassword());
        }
        List<User> users = userMapper.selectByExample(example);
        return users.size()==0?null:users.get(0);
    }

    @Override
    public void UpdataPwd(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void Register(User user) {
        user.setGroupid(1);
        userMapper.insert(user);
    }

    @Override
    public boolean CheekUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (username!=null&&username.length()>0){
            criteria.andUsernameEqualTo(username);
        }
        List<User> users = userMapper.selectByExample(example);
        return users.size()==0?true:false;
    }
}
