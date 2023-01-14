package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDaoHiber = new UserDaoHibernateImpl(); //не понял, почему неправильно.
    public void createUsersTable() {                  //Я же создаю объект класса и обращаюсь к нему через интерфейс UserDao
        userDaoHiber.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHiber.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHiber.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHiber.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> listOfUsers = userDaoHiber.getAllUsers();
        return listOfUsers;
    }

    public void cleanUsersTable() {
        userDaoHiber.cleanUsersTable();
    }
}
