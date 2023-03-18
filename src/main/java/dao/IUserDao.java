package dao;

import domain.User;

import java.util.List;

public interface IUserDao {
    // create
    void create(User user);

    // read
    List<User> getAll();

    User getById(int id);

    User getByLogin(String login);

}
