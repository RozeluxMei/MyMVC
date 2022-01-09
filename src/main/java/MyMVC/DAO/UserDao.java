package MyMVC.DAO;

import MyMVC.model.User;
import java.util.List;


public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void remove(long id);
    void update (User user);
    User getUser (long id);
}
