package ng.storageapp.backend.dto;

import lombok.Data;

@Data

public class UserItemDTO {
    private long userID;
    private String userName;
    private long itemID;
    private String itemName;
}
