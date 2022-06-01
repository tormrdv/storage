package ng.storageapp.backend.service;

import lombok.AllArgsConstructor;
import ng.storageapp.backend.model.Item;
import ng.storageapp.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class ItemService {


    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems() { return itemRepository.findAll(); }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item getOneItem(Long id) throws Exception {
        //no double connection
        boolean exists = (itemRepository.existsById(id));
        if (exists){
            return itemRepository.findById(id).get();
        }
        throw new Exception();
    }
}
