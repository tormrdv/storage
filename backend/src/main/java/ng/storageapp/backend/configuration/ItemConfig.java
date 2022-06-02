package ng.storageapp.backend.configuration;

import ng.storageapp.backend.model.Item;
import ng.storageapp.backend.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner itemCommandLineRunner(ItemRepository repository) {
        return args -> {
            /*Item phone = new Item(
                    1L,
                    "telo",
                    55,
                    10.5,
                    "blue",
                    200,
                    "abc",

            );
            repository.save(phone);*/
        };
    }
}
