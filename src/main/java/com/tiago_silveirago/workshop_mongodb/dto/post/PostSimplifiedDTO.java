package com.tiago_silveirago.workshop_mongodb.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record PostSimplifiedDTO(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
                                Instant date,
                                String title,
                                String body) {

}
