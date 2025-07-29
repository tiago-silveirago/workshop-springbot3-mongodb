package com.tiago_silveirago.workshop_mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Document
public class Comment implements Serializable {

    @Id
    private String id;
    private String text;
    private Instant date;
    private User author;
    private Post post;

    public Comment() {
    }

    public Comment(String id, String text, Instant date, User author, Post post) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.author = author;
        this.post = post;
    }

    public Comment(String id, String text, Instant date, User author) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
