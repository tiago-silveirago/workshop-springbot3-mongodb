package com.tiago_silveirago.workshop_mongodb.factories;

import com.tiago_silveirago.workshop_mongodb.domain.Post;
import com.tiago_silveirago.workshop_mongodb.dto.post.PostResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.post.SimplePostDTO;

import java.util.List;

public class PostFactory {

    private PostFactory() {
    }

    public static SimplePostDTO convertToSimplePostDto(Post post) {

        return new SimplePostDTO(
                post.getDate(),
                post.getTitle(),
                post.getBody());
    }

    public static List<SimplePostDTO> convertToSimplePostDto(List<Post> posts) {

        return posts.stream()
                .map(PostFactory::convertToSimplePostDto)
                .toList();
    }

    public static PostResponseDTO convertToDto(Post post) {

        return new PostResponseDTO(
                post.getDate(),
                post.getTitle(),
                post.getBody(),
                UserFactory.convertToSimpleUserDto(post.getAuthor()));
    }

    public static List<PostResponseDTO> convertToDto(List<Post> posts) {

        return posts.stream()
                .map(PostFactory::convertToDto)
                .toList();
    }
}
