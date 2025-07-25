package com.tiago_silveirago.workshop_mongodb.factories;

import com.tiago_silveirago.workshop_mongodb.domain.UserEntity;
import com.tiago_silveirago.workshop_mongodb.dto.UserResponseDTO;

import java.util.List;

public class UserFactory {

    private UserFactory() {
    }

    public static UserResponseDTO convertToDto(UserEntity user) {
        return new UserResponseDTO(user.getName(), user.getEmail());
    }

    public static List<UserResponseDTO> convertToDto(List<UserEntity> users) {

        return users.stream()
                .map(UserFactory::convertToDto)
                .toList();
    }
}
