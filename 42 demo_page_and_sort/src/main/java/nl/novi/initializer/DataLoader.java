package nl.novi.initializer;

import nl.novi.DemoPageAndSortApplication;
import nl.novi.model.Item;
import nl.novi.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoPageAndSortApplication.class);

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            String name = String.format("Item_%03d", i);
            Random r = new Random();
            char c = (char) (r.nextInt(26) + 'A');
            String description = String.format("%c - %03d - Another demo item to seed in the database.", c, i);
            Item item = new Item(name, description);
            itemRepository.save(item);
        }
        log.info("Database seeded");
    }

}
