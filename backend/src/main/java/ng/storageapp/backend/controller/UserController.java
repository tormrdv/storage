package ng.storageapp.backend.controller;

import lombok.RequiredArgsConstructor;
import ng.storageapp.backend.dto.UserDTO;
import ng.storageapp.backend.service.UserMapper;
import ng.storageapp.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private UserService userService;
    private UserMapper mapper;

    @GetMapping
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getUsers()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    
}
