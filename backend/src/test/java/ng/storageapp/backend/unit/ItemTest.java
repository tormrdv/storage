package ng.storageapp.backend.unit;


import ng.storageapp.backend.controller.ItemController;
import ng.storageapp.backend.model.Item;
import ng.storageapp.backend.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
@AutoConfigureMockMvc
public class ItemTest {

    @MockBean
    ItemService itemService;



    @Test
    public void testfindAll() throws Exception {
        Item item = new Item();
        List<Item> items = Arrays.asList(item);

        Mockito.when(itemService.getItems()).thenReturn(items);
    }

}