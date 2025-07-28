package com.tiago_silveirago.workshop_mongodb.dto.user;

import com.tiago_silveirago.workshop_mongodb.dto.post.SimplePostDTO;

import java.util.List;

public record UserResponseDTO(String name,
                              String email,
                              List<SimplePostDTO> posts) {

}
