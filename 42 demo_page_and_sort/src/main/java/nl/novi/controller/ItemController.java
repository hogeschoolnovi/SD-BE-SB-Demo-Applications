package nl.novi.controller;

import nl.novi.model.Item;
import nl.novi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public List<Item> getAllItems(
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,name") String[] sort)
    {


        Pageable pagingSort = PageRequest.of(page, size, Sort.by(sort));

        Page<Item> pageOfItems;
        if (description == null) {
            pageOfItems = this.itemRepository.findAll(pagingSort);
        }
        else {
            pageOfItems = this.itemRepository.findAllByDescriptionStartsWith(description, pagingSort);
        }

        return pageOfItems.getContent();
    }

}
