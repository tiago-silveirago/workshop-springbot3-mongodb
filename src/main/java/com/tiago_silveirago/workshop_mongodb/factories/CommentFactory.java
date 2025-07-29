package com.tiago_silveirago.workshop_mongodb.factories;

import com.tiago_silveirago.workshop_mongodb.domain.Comment;
import com.tiago_silveirago.workshop_mongodb.dto.comment.CommentResponseDTO;

import java.util.List;

public class CommentFactory {

    private CommentFactory() {
    }

    public static CommentResponseDTO convertToDto(Comment comment) {

        return new CommentResponseDTO(
                comment.getText(),
                comment.getDate(),
                UserFactory.convertToUserNameDto(comment.getAuthor()));
    }

    public static List<CommentResponseDTO> convertToDto(List<Comment> comments) {

        return comments.stream()
                .map(CommentFactory::convertToDto)
                .toList();
    }
}
