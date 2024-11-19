package com.monodev.ummaker.user;

import com.monodev.ummaker.user.dto.UserDTO;
import com.monodev.ummaker.user.dto.request.SaveUserRequest;
import com.monodev.ummaker.user.exception.UserAlreadyExistsException;
import com.monodev.ummaker.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO saveUser(SaveUserRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw UserAlreadyExistsException.withUsername(request.getUsername());
        }

        userRepository.save(new User()
                .setUsername(request.getUsername())
                .setPicture(request.getPicture()));

        return new UserDTO(request.getUsername(), request.getPicture());
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void removeUserById(Long id) {
        var user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
