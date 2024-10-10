package com.estsoft.example.springdemoproject.service;

import com.estsoft.example.springdemoproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


}
