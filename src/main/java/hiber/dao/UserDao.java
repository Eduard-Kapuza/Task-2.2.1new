package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
   void add(User user);

   User getUserByCarModelAndSeries(String model, int series);

   List<User> listUsers();
}