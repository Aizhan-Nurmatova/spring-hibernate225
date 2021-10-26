package hiber.dao;


import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }


   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return sessionFactory.openSession().createQuery("FROM User").getResultList();
   }

   @Override
   public User getModelCar(String model) {
      List <User> users = sessionFactory.openSession().createQuery("from User").getResultList();
      User user = null;
      for (int i = 0; i < users.size(); i++) {
         if (users.get(i).getCar().getModel().equals(model)){
            user = users.get(i);
         }
      }
      return user;
   }

   @Override
   public User getSeries(int series) {
      List <User> users = sessionFactory.openSession().createQuery("from User").getResultList();
      User user = null;
      for (int i = 0; i < users.size(); i++) {
         if (users.get(i).getCar().getSeries() == series){
            user = users.get(i);
         }
      }
      return user;
   }

   @Override
   public User gerCarOwner(String model, int series) {
      List<User> users = sessionFactory.openSession().createQuery("from User").getResultList();
      User user = null;
      for (int i = 0; i < users.size(); i++){
         if(users.get(i).getCar().getModel().equals(model) && users.get(i).getCar().getSeries() == series){
            user = users.get(i);
         }
      }
      return user;
   }
}
