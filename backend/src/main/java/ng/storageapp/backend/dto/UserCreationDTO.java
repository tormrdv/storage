package ng.storageapp.backend.dto;

import lombok.Data;

@Data

public class UserCreationDTO {
    private String name;
    private String email;
    private String password;
    private String role;
}
