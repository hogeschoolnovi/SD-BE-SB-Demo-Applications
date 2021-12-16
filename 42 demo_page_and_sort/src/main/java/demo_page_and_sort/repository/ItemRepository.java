package demo_page_and_sort.repository;

import demo_page_and_sort.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
