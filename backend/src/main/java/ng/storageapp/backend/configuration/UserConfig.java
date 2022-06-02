package ng.storageapp.backend.configuration;

import ng.storageapp.backend.model.User;
import ng.storageapp.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository repository){
        return args -> {
            /*User admin = new User(
                    1L,
                    "admin",
                    "root@root.com",
                    "4813494D137E1631BBA301D5ACAB6E7BB7AA74CE1185D456565EF51D737677B2",
                    true,
                    null,
                    null
            )*/
        };
    }
}
