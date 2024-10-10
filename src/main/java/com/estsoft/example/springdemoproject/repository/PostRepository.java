package com.estsoft.example.springdemoproject.repository;

import com.estsoft.example.springdemoproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    // select * from post where is_deleted = 0 and user_id = 1 order by created_at desc
    List<Post> findAllByIsDeletedAndUserIdOrderByCreatedAtDesc(Boolean isDeleted);

    // select * from where id = :postId AND is_deleted = :isDeleted
    Post findByIdAndIsDeleted(Long postId, Boolean isDeleted);
}
