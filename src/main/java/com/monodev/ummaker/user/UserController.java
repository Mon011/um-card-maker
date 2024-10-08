package com.monodev.ummaker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/{id}")
    public UserDTO findUserByUsername(@PathVariable("id") Long id) {
        return userService.findUserByUsername(id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> removeUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);

        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }


}
