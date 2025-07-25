package com.tiago_silveirago.workshop_mongodb.controllers;

import com.tiago_silveirago.workshop_mongodb.domain.UserEntity;
import com.tiago_silveirago.workshop_mongodb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
