package com.tiago_silveirago.workshop_mongodb.services;

import com.tiago_silveirago.workshop_mongodb.domain.User;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserRequestDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserResponseDTO;
import com.tiago_silveirago.workshop_mongodb.dto.user.UserWithPostReferencesDTO;
import com.tiago_silveirago.workshop_mongodb.repositories.UserRepository;
import com.tiago_silveirago.workshop_mongodb.services.exeptions.DocumentInUseException;
import com.tiago_silveirago.workshop_mongodb.services.exeptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.tiago_silveirago.workshop_mongodb.factories.UserFactory.*;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserWithPostReferencesDTO> findAll() {
        List<User> users = repository.findAll();

        return convertToDtoWithPostReferences(users);
    }

    public UserResponseDTO findById(String id) {
        User user = ensureUserExists(id);

        return convertToDto(user);
    }

    public UserWithPostReferencesDTO findByIdWithPostReferences(String id) {
        User user = ensureUserExists(id);

        return convertToDtoWithPostReferences(user);
    }

    public UserResponseDTO insert(UserRequestDTO request) {
        User user = fromRequest(request);
        User savedUser = repository.save(user);

        return convertToDto(savedUser);
    }

    public void delete(String id) {
        ensureUserExists(id);

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DocumentInUseException("Invalid action. User is linked to one or more posts.");
        }
    }

    public UserResponseDTO update(String id, UserRequestDTO request) {
        User user = ensureUserExists(id);
        user.setName(request.name());
        user.setEmail(request.email());

        User savedUser = repository.save(user);

        return convertToDto(savedUser);
    }

    private User ensureUserExists(String id) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ObjectNotFoundException("User not found");
        }

        return optionalUser.get();
    }
}
