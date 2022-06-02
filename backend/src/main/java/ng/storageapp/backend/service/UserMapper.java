package ng.storageapp.backend.service;

import ng.storageapp.backend.dto.UserCreationDTO;
import ng.storageapp.backend.dto.UserDTO;
import ng.storageapp.backend.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMapper {

    public UserDTO toDto(User user) {
        long id = user.getId();
        String name = user.getName();
        String email = user.getEmail();
       //boolean isAdmin = user.isAdmin();

        return new UserDTO(id, name, email);
    }

    public User toUser(UserCreationDTO userDTO){
        return new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.isAdmin());
    }
}
