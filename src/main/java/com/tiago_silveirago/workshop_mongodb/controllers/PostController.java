package com.tiago_silveirago.workshop_mongodb.controllers;

import com.tiago_silveirago.workshop_mongodb.controllers.util.URL;
import com.tiago_silveirago.workshop_mongodb.dto.post.PostResponseDTO;
import com.tiago_silveirago.workshop_mongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/posts", "/posts/"})
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> findAll() {
        List<PostResponseDTO> responses = service.findAll();

        return ResponseEntity.ok().body(responses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable String id) {
        PostResponseDTO response = service.findById(id);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostResponseDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParameter(text);
        List<PostResponseDTO> responses = service.findByTitle(text);

        return ResponseEntity.ok().body(responses);
    }
}
