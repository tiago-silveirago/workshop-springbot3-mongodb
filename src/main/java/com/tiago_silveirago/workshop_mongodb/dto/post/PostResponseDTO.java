package com.tiago_silveirago.workshop_mongodb.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tiago_silveirago.workshop_mongodb.dto.comment.CommentResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserNameDTO;

import java.time.Instant;
import java.util.List;

public record PostResponseDTO(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
                              Instant date,
                              String title,
                              String body,
                              UserNameDTO author,
                              List<CommentResponseDTO> comments) {

}
