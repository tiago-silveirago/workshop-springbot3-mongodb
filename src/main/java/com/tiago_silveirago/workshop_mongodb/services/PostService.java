package com.tiago_silveirago.workshop_mongodb.services;

import com.tiago_silveirago.workshop_mongodb.domain.Post;
import com.tiago_silveirago.workshop_mongodb.dto.post.PostResponseDTO;
import com.tiago_silveirago.workshop_mongodb.repositories.PostRepository;
import com.tiago_silveirago.workshop_mongodb.services.exeptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.tiago_silveirago.workshop_mongodb.factories.PostFactory.convertToDto;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<PostResponseDTO> findAll() {
        List<Post> posts = repository.findAll();

        return convertToDto(posts);
    }

    public PostResponseDTO findById(String id) {
        Post post = ensureUserExists(id);

        return convertToDto(post);
    }

    private Post ensureUserExists(String id) {
        Optional<Post> optionalPost = repository.findById(id);

        if (optionalPost.isEmpty()) {
            throw new ObjectNotFoundException("Post not found");
        }

        return optionalPost.get();
    }

    public List<PostResponseDTO> findByTitle(String text) {
        List<Post> posts = repository.findByTitle(text);

        return convertToDto(posts);
    }
}
