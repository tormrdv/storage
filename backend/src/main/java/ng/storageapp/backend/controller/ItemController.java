package ng.storageapp.backend.controller;

import lombok.RequiredArgsConstructor;
import ng.storageapp.backend.model.Item;
import ng.storageapp.backend.repository.ItemRepository;
import ng.storageapp.backend.service.ItemService;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.*;

@RestController
@RequestMapping(path = "api/v1/item")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor

public class ItemController {
    //Connect itemservice class
    //Singleton (no new object every iteration)

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @GetMapping("all")
    //returns item list for query
    public List<Item> GetItems() {
        return itemService.getItems();
    }

    //POST query with body | no need to create new path for post
    //returns nothing, requires body and type to convert body into
    @PostMapping
    public Item PostItem(@RequestBody Item item) {
        itemService.saveItem(item);
        //return "Added " + item.getName();
        return (item);
        //pseudoprobleem atm
        /*return new ResponseEntity<Item>("", response ,HttpStatus.OK);*/
    }

    //get item by id
    @GetMapping("{id}")
    public Item getOneItem(@PathVariable Long id) throws Exception {
        return itemService.getOneItem(id);
    }

    @DeleteMapping("{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "deleted" + id;
    }

    /*@DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItemRes(@PathVariable Long id) throws Exception {
        Item item = itemService.getOneItem(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException( "s" + Item + "not ok"));

        itemService.deleteItem(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }*/
    //todo
    //Database +
    //storage services -
    //2x yhendus services +-
    //getoneitem nullpointer +
    //testid -
    //data transfer object -+
    //entitiy ilma primitive

}