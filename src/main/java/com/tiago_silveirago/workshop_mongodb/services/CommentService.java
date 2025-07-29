package com.tiago_silveirago.workshop_mongodb.services;

import com.tiago_silveirago.workshop_mongodb.domain.Comment;
import com.tiago_silveirago.workshop_mongodb.dto.comment.CommentResponseDTO;
import com.tiago_silveirago.workshop_mongodb.factories.CommentFactory;
import com.tiago_silveirago.workshop_mongodb.repositories.CommentRepository;
import com.tiago_silveirago.workshop_mongodb.services.exeptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.tiago_silveirago.workshop_mongodb.factories.CommentFactory.convertToDto;

@Service
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public List<CommentResponseDTO> findAll() {
        List<Comment> comments = repository.findAll();

        return convertToDto(comments);
    }

    public CommentResponseDTO findById(String id) {
        Comment comment = ensureUserExists(id);

        return convertToDto(comment);
    }

    private Comment ensureUserExists(String id) {
        Optional<Comment> optionalComment = repository.findById(id);

        if (optionalComment.isEmpty()) {
            throw new ObjectNotFoundException("Comment not found");
        }

        return optionalComment.get();
    }
}
