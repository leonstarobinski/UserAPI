package com.userapp.example.demo.Controller;


import com.userapp.example.demo.Models.User;
import com.userapp.example.demo.Models.UserValidator;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class UserSystem {

    Map<Integer, User> users = new HashMap<>();

    private static int idCount = 1;


    @GetMapping(value = "/users")
    public Collection<User> getUsers() {
        return users.values();
    }
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        if(UserValidator.validate(user)) {
            user.setId(idCount);
            users.put(idCount, user);
            idCount++;
            return "saved..";
        }
        else return "invalid user";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        if(users.get(id) == null) return "not found..";
        if(UserValidator.validate(user)) {
            User updatedUser = users.get(id);
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setBirthday(user.getBirthday());
        }
        return "changed..";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id){
        if(users.get(id) == null) return "not found..";
        users.remove(id);
        return "removed..";
    }
}
