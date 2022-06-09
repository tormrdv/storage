package ng.storageapp.backend.service;

import lombok.AllArgsConstructor;
import ng.storageapp.backend.dto.ItemStorageDTO;
import ng.storageapp.backend.model.Item;
import ng.storageapp.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item getOneItem(Long id) throws Exception {
        //no double connection
        //boolean exists = (itemRepository.existsById(id));
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new Exception();
    }

    public List<ItemStorageDTO> getAllItemStorage() {
        return itemRepository.findAll()
                .stream()
                .map(this::convertEntToDTO)
                .collect(Collectors.toList());
    }

    public ItemStorageDTO convertEntToDTO(Item item) {
        ItemStorageDTO itemStorageDTO = new ItemStorageDTO();
        itemStorageDTO.setItemID(item.getId());/*
        itemStorageDTO.setStorageID(item.ge().getId());
        itemStorageDTO.setName(item.getStorage().getName());
*/
        return itemStorageDTO;
    }
}


