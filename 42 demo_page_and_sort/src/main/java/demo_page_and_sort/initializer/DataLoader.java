package demo_page_and_sort.initializer;

import demo_page_and_sort.DemoPageAndSortApplication;

import demo_page_and_sort.model.Item;
import demo_page_and_sort.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoPageAndSortApplication.class);

    private ItemRepository itemRepository;

    @Autowired
    public DataLoader(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            String name = String.format("Item_%d", i);
            String description = String.format("%d - Another demo item to seed in the database.", i);
            Item item = new Item(name, description);
            itemRepository.save(item);
        }
        log.info("Database seeded");
    }

}