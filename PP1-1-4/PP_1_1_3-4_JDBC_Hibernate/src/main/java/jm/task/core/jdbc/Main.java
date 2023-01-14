package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();

        User user1 = new User("Ivan", "Popov", (byte)23);
        User user2 = new User("Pyotr", "Petrov", (byte)33);
        User user3 = new User("Gena", "Gorin", (byte)44);
        User user4 = new User("Leonid", "Brezhnev", (byte)94);
        User[] users = {user1, user2, user3, user4};
        for (User u: users) {
            usi.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.println("User с именем – " + u.getName() + " добавлен в базу данных");
        }

        System.out.println(usi.getAllUsers());

        usi.cleanUsersTable();

        usi.dropUsersTable();

        Util.getSessionFactory().close();
    }
}
