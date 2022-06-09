package ng.storageapp.backend.dto;

import lombok.Data;

@Data

public class UserItemDTO {
    private Long userID;
    private Long storageID;
    private Long storageItemID;
    private String userName;
    private String storageName;
    private String itemName;
}
