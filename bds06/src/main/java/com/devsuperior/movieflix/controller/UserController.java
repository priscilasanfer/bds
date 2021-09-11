package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.UserDto;
import com.devsuperior.movieflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile() {
        UserDto userDTO = service.getProfile();
        return ResponseEntity.ok(userDTO);
    }
}
