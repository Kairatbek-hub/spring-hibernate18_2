package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   List<Object[]> listOfRequiredUsersByModel(String model);
   List<Object[]> listOfRequiredUsersBySeries(int series);
}
