package com.tiago_silveirago.workshop_mongodb.factories;

import com.tiago_silveirago.workshop_mongodb.domain.Post;
import com.tiago_silveirago.workshop_mongodb.dto.post.PostResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.post.PostSimplifiedDTO;

import java.util.List;

public class PostFactory {

    private PostFactory() {
    }

    public static PostSimplifiedDTO convertToPostSimplifiedDto(Post post) {

        return new PostSimplifiedDTO(
                post.getDate(),
                post.getTitle(),
                post.getBody());
    }

    public static List<PostSimplifiedDTO> convertToPostSimplifiedDto(List<Post> posts) {

        return posts.stream()
                .map(PostFactory::convertToPostSimplifiedDto)
                .toList();
    }

    public static PostResponseDTO convertToDto(Post post) {

        return new PostResponseDTO(
                post.getDate(),
                post.getTitle(),
                post.getBody(),
                UserFactory.convertToUserNameDto(post.getAuthor()),
                CommentFactory.convertToDto(post.getComments()));
    }

    public static List<PostResponseDTO> convertToDto(List<Post> posts) {

        return posts.stream()
                .map(PostFactory::convertToDto)
                .toList();
    }
}
