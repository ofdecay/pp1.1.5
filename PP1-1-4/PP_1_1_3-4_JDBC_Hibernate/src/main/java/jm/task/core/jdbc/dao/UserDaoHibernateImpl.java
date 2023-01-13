package jm.task.core.jdbc.dao;

import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.SessionFactory;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        openTransactionSession();
        Session session = getSession();
        String sql = "CREATE TABLE IF NOT EXISTS USERS_TABLE" +
                "  (ID BIGINT NOT NULL AUTO_INCREMENT," +
                "  NAME VARCHAR(45) NOT NULL," +
                "  LAST_NAME VARCHAR(45) NOT NULL," +
                "  AGE TINYINT NOT NULL," +
                "  PRIMARY KEY (ID))";
        session.createSQLQuery(sql).executeUpdate();
        closeTransactionSession();
    }

    @Override
    public void dropUsersTable() {
        openTransactionSession();
        Session session = getSession();
        String sql = "DROP TABLE IF EXISTS USERS_TABLE";
        session.createSQLQuery(sql).executeUpdate();
        closeTransactionSession();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        openTransactionSession();
        Session session = getSession();
        session.save(user);
        closeTransactionSession();
    }

    @Override
    public void removeUserById(long id) {
        openTransactionSession();
        Session session = getSession();
        User user = session.get(User.class, id);
        session.delete(user);
        closeTransactionSession();
    }

    @Override
    public List<User> getAllUsers() {
        openTransactionSession();
        Session session = getSession();
        List<User> listOfUsers = session.createQuery("from User").getResultList();
        closeTransactionSession();
        return listOfUsers;
    }

    @Override
    public void cleanUsersTable() {
        openTransactionSession();
        Session session = getSession();
        String sql = "TRUNCATE TABLE USERS_TABLE";
        session.createSQLQuery(sql).executeUpdate();
        closeTransactionSession();
    }
}
