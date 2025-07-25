package com.tiago_silveirago.workshop_mongodb.services;

import com.tiago_silveirago.workshop_mongodb.domain.UserEntity;
import com.tiago_silveirago.workshop_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
