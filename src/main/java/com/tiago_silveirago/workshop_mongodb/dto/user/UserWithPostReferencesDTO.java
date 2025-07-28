package com.tiago_silveirago.workshop_mongodb.dto.user;

import java.util.List;

public record UserWithPostReferencesDTO(String name,
                                        String email,
                                        List<String> postReferences) {

}
