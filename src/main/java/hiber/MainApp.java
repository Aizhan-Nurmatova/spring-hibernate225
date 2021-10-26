package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
//      userService.add(new User("Sezim","Satybaldieva","satybaldieva@gmai.com",new Car("Tesla", 2020)));
//      userService.add(new User("Beksultan","Mamatkayr uulu","beksultan@gmail.com",new Car("Toyota",2018)));
//      userService.add(new User("Aybek","Zhumaev","aybek@mail.ru",new Car("Honda",2021)));
//      userService.add(new User("Aizhan","Nurmatova","nurmtova@mail.ru",new Car("Toyota",2021)));
//      userService.add(new User("Rayim","Tashmamat uulu","million@mail.ru",new Car("Mercedes",2018)));
//
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+ user.getCar());
//         System.out.println("------------------------------------------");
//      }


      System.out.println(userService.getModelCar("Tesla"));
      System.out.println(userService.getSeries(2021));
      System.out.println(userService.gerCarOwner("Tesla",2020));

      context.close();
   }

}
