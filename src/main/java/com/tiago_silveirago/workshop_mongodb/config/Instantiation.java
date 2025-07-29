package com.tiago_silveirago.workshop_mongodb.config;

import com.tiago_silveirago.workshop_mongodb.domain.Comment;
import com.tiago_silveirago.workshop_mongodb.domain.Post;
import com.tiago_silveirago.workshop_mongodb.domain.User;
import com.tiago_silveirago.workshop_mongodb.repositories.CommentRepository;
import com.tiago_silveirago.workshop_mongodb.repositories.PostRepository;
import com.tiago_silveirago.workshop_mongodb.repositories.UserRepository;
import com.tiago_silveirago.workshop_mongodb.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, DateUtils.convertToInstant("2018/03/21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, DateUtils.convertToInstant("2018/03/23"), "Bom dia", "Acordei feliz hoje!", maria);

        Comment comment1 = new Comment(null, "Boa viagem mano!", DateUtils.convertToInstant("2018/03/21"), alex);
        Comment comment2 = new Comment(null, "Aproveite!", DateUtils.convertToInstant("2018/03/22"), bob);
        Comment comment3 = new Comment(null, "Tenha um ótimo dia!", DateUtils.convertToInstant("2018/03/23"), alex);

        commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
