package com.tiago_silveirago.workshop_mongodb.controllers;

import com.tiago_silveirago.workshop_mongodb.dto.comment.CommentResponseDTO;
import com.tiago_silveirago.workshop_mongodb.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/comments", "/comments/"})
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDTO>> findAll() {
        List<CommentResponseDTO> responses = service.findAll();

        return ResponseEntity.ok().body(responses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentResponseDTO> findById(@PathVariable String id) {
        CommentResponseDTO response = service.findById(id);

        return ResponseEntity.ok().body(response);
    }
}
