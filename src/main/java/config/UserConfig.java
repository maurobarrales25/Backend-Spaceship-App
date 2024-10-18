package config;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User tom = new User(
                    "Tom Brady",
                    "brady12",
                    "tomb12@example.com",
                    "121212"
            );

            User jack = new User(
                    "Jack Nicholson",
                    "JackN",
                    "nicholson@example.com",
                    "jackjack"
            );

            repository.saveAll(
                    List.of(tom, jack)
            );
        };
    }
}
