package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User getModelCar(String model) {
      return userDao.getModelCar(model);
   }

   @Override
   public User getSeries(int series) {
      return userDao.getSeries(series);
   }

   @Override
   public User gerCarOwner(String model, int series) {
      return userDao.gerCarOwner(model,series);
   }


}
