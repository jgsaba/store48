package com.jorge.backend.userapi.controller;

import com.jorge.backend.userapi.service.UserService;
import model.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO getUser(@PathVariable String cpf, @RequestParam String userKey){
        return userService.findByCpf(cpf, userKey);
    }

    @GetMapping("/name-like/{name}")
    public List<UserDTO> searchLike(String name){
        return userService.queryByName(name);
    }

    @PostMapping
    public UserDTO insertNewUser(@RequestBody UserDTO newUser){
        return userService.save(newUser);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id){
        userService.delete(id);
    }
}
