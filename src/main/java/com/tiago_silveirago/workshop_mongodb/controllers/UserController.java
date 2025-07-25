package com.tiago_silveirago.workshop_mongodb.controllers;

import com.tiago_silveirago.workshop_mongodb.domain.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        UserEntity maria = new UserEntity("1", "Maria Brown", "maria@gmail.com");
        UserEntity alex = new UserEntity("2", "Alex Green", "alex@gmail.com");
        List<UserEntity> list = new ArrayList<>(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
