package web.dao;

import web.usermanager.model.User;

import java.util.List;

public interface UserDao {

    public void addUpdateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers();
}
