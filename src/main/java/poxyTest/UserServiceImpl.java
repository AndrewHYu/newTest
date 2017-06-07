package poxyTest;

/**
 * Created by Andrew on 2016/5/28.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("add into database");
    }

    @Override
    public User getUser(int id) {
        User user=new User();
        user.setId(id);
        System.out.println("get userId from database");
        return user;

    }
}
