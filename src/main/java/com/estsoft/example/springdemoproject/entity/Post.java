package com.estsoft.example.springdemoproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
public class Post {
    @Id
    private Long id;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1)")
    private String isDeleted;

    @Column(name = "deleted_at")
    private String deletedAt;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
