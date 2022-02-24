package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

//      User user1 = new User("Sadio", "Mane", "mane@mail.ru");
//      Car car1 = new Car("Lexus", 350);
//      car1.setUser(user1);
//      user1.setCar(car1);
//      userService.add(user1);
//
//      User user2 = new User("Mohammed", "Salah", "salah@mail.ru");
//      Car car2 = new Car("Toyota", 300);
//      car2.setUser(user2);
//      user2.setCar(car2);
//      userService.add(user2);
//
//      User user3 = new User("Leo", "Messi", "messi@mail.ru");
//      Car car3 = new Car("BMW", 5);
//      car3.setUser(user3);
//      user3.setCar(car3);
//      userService.add(user3);
//
//      User user4 = new User("Karim", "Benzema", "benzema@mail.ru");
//      Car car4 = new Car("BMW", 7);
//      car4.setUser(user4);
//      user4.setCar(car4);
//      userService.add(user4);
//
//      User user5 = new User("Son", "Heung-min", "son@mail.ru");
//      Car car5 = new Car("Lexus", 300);
//      car5.setUser(user5);
//      user5.setCar(car5);
//      userService.add(user5);
//
//      User user7 = new User("Cristiano", "Ronaldo", "ronaldo@mail.ru");
//      Car car7 = new Car("Lexus", 500);
//      car7.setUser(user7);
//      user7.setCar(car7);
//      userService.add(user7);

//            List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = " + user.getCar());
//      }

      List<Object[]> listOfRequiredUsersByModel = userService.listOfRequiredUsersByModel("BMW");
      for (Object[] arr : listOfRequiredUsersByModel) {
         System.out.println(Arrays.toString(arr));
      }

      List<Object[]> listOfRequiredUsersBySeries = userService.listOfRequiredUsersBySeries(300);
      for (Object[] arr : listOfRequiredUsersBySeries) {
         System.out.println(Arrays.toString(arr));
      }

      context.close();
   }
}
