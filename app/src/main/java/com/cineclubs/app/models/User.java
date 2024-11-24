package com.cineclubs.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")

public class User {
    @Id
    private String userId;

    @Column(nullable = false)
    private String email;

    private String firstName;
    private String lastName;
    private String imageUrl;

    @Column(nullable = false)
    private String username;

    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @ManyToMany(mappedBy = "likes")
    private Set<Post> likedPosts;

    @ManyToMany(mappedBy = "likes")
    private Set<Comment> likedComments;

    public User() {
    }

    public User(String userId, String email, String firstName, String lastName, String imageUrl, String username, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Post> posts, Set<Comment> comments, Set<Post> likedPosts, Set<Comment> likedComments) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.posts = posts;
        this.comments = comments;
        this.likedPosts = likedPosts;
        this.likedComments = likedComments;
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public Set<Comment> getLikedComments() {
        return likedComments;
    }

    public void setLikedComments(Set<Comment> likedComments) {
        this.likedComments = likedComments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
}
