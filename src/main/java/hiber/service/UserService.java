package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<Object[]> listOfRequiredUsersByModel(String model);
    List<Object[]> listOfRequiredUsersBySeries(int series);
}
