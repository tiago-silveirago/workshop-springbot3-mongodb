package com.tiago_silveirago.workshop_mongodb.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiago_silveirago.workshop_mongodb.dto.user.SimpleUserDTO;

import java.time.Instant;

public record PostResponseDTO(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
                              Instant date,
                              String title,
                              String body,
                              SimpleUserDTO author) {

}
