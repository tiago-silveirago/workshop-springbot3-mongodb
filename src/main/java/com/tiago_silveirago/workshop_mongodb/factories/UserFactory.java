package com.tiago_silveirago.workshop_mongodb.factories;

import com.tiago_silveirago.workshop_mongodb.domain.User;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserRequestDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserResponseDTO;

import java.util.List;

public class UserFactory {

    private UserFactory() {
    }

    public static User fromRequest(UserRequestDTO request) {
        return new User(null, request.name(), request.email());
    }

    public static UserResponseDTO convertToDto(User user) {
        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public static List<UserResponseDTO> convertToDto(List<User> users) {

        return users.stream()
                .map(UserFactory::convertToDto)
                .toList();
    }
}
