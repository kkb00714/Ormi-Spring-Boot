package com.estsoft.springproject.user.service;

import com.estsoft.springproject.user.domain.Users;
import com.estsoft.springproject.user.domain.dto.AddUserRequest;
import com.estsoft.springproject.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository,
                       BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    // 회원가입  처리
    public Users save(AddUserRequest dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();
        String encodedPassword = encoder.encode(password);

        Users users = new Users(email, encodedPassword);
        return repository.save(users);
    }
}
