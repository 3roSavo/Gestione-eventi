package savogineros.Gestioneeventi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import savogineros.Gestioneeventi.DTO.users.UserResponseDTO;
import savogineros.Gestioneeventi.entities.User;
import savogineros.Gestioneeventi.services.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("")
    public List<UserResponseDTO> getUsers() {
        List<User> userList = usersService.getAllUsers();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();  // payload di risposta custom
        userList.forEach(user -> userResponseDTOList.add(new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole())));

        return userResponseDTOList;
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUserById(@PathVariable UUID userId) {
        User user = usersService.getUserById(userId);
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole());
    }



    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID userId) {
        usersService.deleteUser(userId);
    }




}
