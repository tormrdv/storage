package ng.storageapp.backend.service;

import lombok.AllArgsConstructor;
import ng.storageapp.backend.dto.UserDTO;
import ng.storageapp.backend.dto.UserItemDTO;
import ng.storageapp.backend.model.User;
import ng.storageapp.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() { return userRepository.findAll(); }

    public void saveUser(User user) { userRepository.save(user); }

    /*public UserItemDTO convertEntToDTO(User user){
        UserItemDTO userItemDTO = new UserItemDTO();
        userItemDTO.setUserID(user.getId());
        userItemDTO.setStorageID(user.getStorages().getId());
        userItemDTO.setItemID(user.getStorages().getClass());
    }*/
}
