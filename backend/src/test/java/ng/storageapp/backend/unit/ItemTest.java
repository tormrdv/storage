package ng.storageapp.backend.unit;

import ng.storageapp.backend.controller.ItemController;
import ng.storageapp.backend.model.Item;
import ng.storageapp.backend.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemTest {

    /*private ItemService itemService;

    @Test
    public void whenGetItem_returnJSON() throws Exception {

        List<Item> allItems = Arrays.asList();
    }*/
}