package com.tiago_silveirago.workshop_mongodb.factories;

import com.tiago_silveirago.workshop_mongodb.domain.Post;
import com.tiago_silveirago.workshop_mongodb.domain.User;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserNameDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserRequestDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserWithPostReferencesDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserFactory {

    private UserFactory() {
    }

    public static User fromRequest(UserRequestDTO request) {
        return new User(null, request.name(), request.email());
    }

    public static UserNameDTO convertToUserNameDto(User user) {
        return new UserNameDTO(user.getName());
    }

    public static UserResponseDTO convertToDto(User user) {
        return new UserResponseDTO(user.getName(), user.getEmail(), PostFactory.convertToPostSimplifiedDto(user.getPosts()));
    }

    public static UserWithPostReferencesDTO convertToDtoWithPostReferences(User user) {
        List<String> postIds = user.getPosts()
                .stream()
                .map(Post::getId)
                .collect(Collectors.toList());

        return new UserWithPostReferencesDTO(user.getName(), user.getEmail(), postIds);
    }

    public static List<UserWithPostReferencesDTO> convertToDtoWithPostReferences(List<User> users) {

        return users.stream()
                .map(UserFactory::convertToDtoWithPostReferences)
                .toList();
    }
}
