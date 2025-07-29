package com.tiago_silveirago.workshop_mongodb.repositories;

import com.tiago_silveirago.workshop_mongodb.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

}
