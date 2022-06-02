package ng.storageapp.backend.dto;

import lombok.Data;

@Data

public class UserItemDTO {
    private long userID;
    private long storageID;
    private long itemID;
    private String userName;
    private String storageName;
    private String itemName;
}
