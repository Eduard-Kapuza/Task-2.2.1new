package hiber.dao;

import hiber.model.User;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Query query = sessionFactory.getCurrentSession().createQuery("from User where car.model=?1 and car.series=?2");
      query.setParameter(1, model);
      query.setParameter(2, series);

      return (User) query.getResultList().stream().findFirst().orElse(new User());
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}