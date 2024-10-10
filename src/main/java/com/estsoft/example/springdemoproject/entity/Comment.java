package com.estsoft.example.springdemoproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

//    @Column(name = "user_id")
//    private Long userId;

    @Column(name = "content")
    private String name;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1)")
    private String isDeleted;

    @Column(name = "deleted_at")
    private String deletedAt;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}
