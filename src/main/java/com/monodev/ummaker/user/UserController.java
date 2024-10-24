package com.monodev.ummaker.user;

import com.monodev.ummaker.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/{username}")
    public UserDTO findUserByUsername(@PathVariable("username") String username) {
        return UserDTO.toDto(userService.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);

        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }


}
