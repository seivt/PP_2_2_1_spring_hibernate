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
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("UserChina1", "LastnameChina1", "userChina1@mail.ru", new Car("Haval", 7)));

        User userGer = new User("UserGer1", "LastnameGer1", "userGer1@mail.ru");
        userGer.setCar(new Car("BMV", 3));
        userService.add(userGer);

        User user = userService.getUserByCar("Haval", 7);
        System.out.println("Id = "+user.getId());
        System.out.println("First Name = "+user.getFirstName());
        System.out.println("Last Name = "+user.getLastName());
        System.out.println("Email = "+user.getEmail());
        System.out.println();
        context.close();
    }
}
