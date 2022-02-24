package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<Object[]> listOfRequiredUsersByModel(String model) {
      String hql = "select u.firstName,u.lastName, c.model from User u inner join Car c on c.id = u.id where c.model =: model";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
         query.setParameter("model",model);
         return query.getResultList();
   }

   @Override
   public List<Object[]> listOfRequiredUsersBySeries(int series) {
      String hql = "select u.firstName,u.lastName,c.model, c.series from User u inner join Car c on c.id = u.id where c.series =: series";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("series",series);
      return query.getResultList();
   }
}
