package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserService {
    void add(User user);

    User findUserByCarModelAndSeries(Car car);

    List<User> listUsers();
}