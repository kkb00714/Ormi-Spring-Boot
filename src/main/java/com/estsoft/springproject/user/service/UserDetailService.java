package com.estsoft.springproject.user.service;

import com.estsoft.springproject.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository repository;

    public UserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    // String username은 사용자가 직접 입력한 값.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username) // username을 찾지 못했을 때 위의 UsernameNotFound 에러가 나올 것.
                .orElseThrow(() -> new IllegalStateException(username));
    }


}
