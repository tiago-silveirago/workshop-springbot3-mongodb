package com.tiago_silveirago.workshop_mongodb.repositories;

import com.tiago_silveirago.workshop_mongodb.domain.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
