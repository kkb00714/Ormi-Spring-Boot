package com.estsoft.springproject.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Authorization, 인가(권한)
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN")); // 개발자가 정의한 역할
        // 역할 ex) 새싹, 주니어, 중니어, 시니어, ... 중니엌ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
    }

    @Override
    public String getUsername() {
        return "";
    }

    // 계정의 만료 여부, true - 만료되지 않음.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠김 여부, true - 잠기지지 않음.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정의 pw 정보 만료 여부, true - 만료되지 않음.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화, true - 활성화됨.
    @Override
    public boolean isEnabled() {
        return true;
    }
}
