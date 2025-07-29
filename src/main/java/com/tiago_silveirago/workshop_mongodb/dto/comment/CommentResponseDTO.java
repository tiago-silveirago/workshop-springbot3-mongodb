package com.tiago_silveirago.workshop_mongodb.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserNameDTO;

import java.time.Instant;

public record CommentResponseDTO(String text,
                                 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
                                 Instant date,
                                 UserNameDTO author) {

}
