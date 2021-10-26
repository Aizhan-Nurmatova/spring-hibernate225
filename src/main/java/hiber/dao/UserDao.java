package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {

   void add(User user);
   List<User> listUsers();
   User getModelCar(String model);
   User getSeries(int series);
   User gerCarOwner(String model,int series);
}
