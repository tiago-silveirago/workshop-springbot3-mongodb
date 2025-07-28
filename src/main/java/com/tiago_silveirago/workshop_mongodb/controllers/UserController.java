package com.tiago_silveirago.workshop_mongodb.controllers;

import com.tiago_silveirago.workshop_mongodb.dto.post.PostResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserRequestDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserWithPostReferencesDTO;
import com.tiago_silveirago.workshop_mongodb.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/users", "/users/"})
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserWithPostReferencesDTO>> findAll() {
        List<UserWithPostReferencesDTO> response = service.findAll();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id) {
        UserResponseDTO response = service.findById(id);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserWithPostReferencesDTO> findByIdWithPostReferences(@PathVariable String id) {
        UserWithPostReferencesDTO response = service.findByIdWithPostReferences(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = service.insert(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody UserRequestDTO request) {
        UserResponseDTO response = service.update(id, request);

        return ResponseEntity.ok().body(response);
    }
}
