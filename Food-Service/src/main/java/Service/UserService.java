package Service;

import pojo.User;

import java.util.List;

public interface UserService {

    public List<User>FindAll();

    public User FindOne(Integer id);

    public User Login(User user);

    public void UpdataPwd(User user);

    public void Register (User user);

    public boolean CheekUsername(String username);

}
