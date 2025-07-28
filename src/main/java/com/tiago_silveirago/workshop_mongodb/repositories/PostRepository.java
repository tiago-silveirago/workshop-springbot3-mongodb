package com.tiago_silveirago.workshop_mongodb.repositories;

import com.tiago_silveirago.workshop_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
