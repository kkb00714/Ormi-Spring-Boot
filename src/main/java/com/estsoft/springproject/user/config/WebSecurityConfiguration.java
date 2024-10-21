package com.estsoft.springproject.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class WebSecurityConfiguration {
    // ignore, 특정 페이지로 접속 시 로그인 페이지로 리다이렉션 하지 않음.
    public WebSecurityCustomizer ignore() {
        return webSecurity -> webSecurity.ignoring()
                .requestMatchers("/static/**") // static 하위 html 페이지에 접근 시 로그인하지 않음.
                .requestMatchers(toH2Console()); // H2Console에 접근 시 로그인하지 않음.
    }

    // 패스워드 암호화 방식 정의 - 패스워드를 암호화 할 수 있음. (Spring Security에서 제공)
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 특정 요청에 대한 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests() // 3) 인증, 인가 설정
                .requestMatchers("/login", "/signup", "/user").permitAll()
//                .requestMatchers("/api/external").hasRole("admin") // 인가
                .anyRequest().authenticated()
                .and()
                .formLogin()        //4) 폼 기반 로그인 설정
                .loginPage("/login")
                // 로그인 페이지
                .defaultSuccessUrl("/articles") // 로그인을 성공했을 때 리다이렉션 URL
                .and()
                .logout()       // 5) 로그아웃 설정
                .logoutSuccessUrl("/login")
                // 로그아웃 성공하면 연결될 페이지
                .invalidateHttpSession(true) // 로그아웃 후 해당 세션을 제거할 것인지 (제거 - true)
                .and()
//                .csrf().disable()       // 6) (현재) csrf 비활성화,, 스프링에서는 default가 활성화.
                .build();
    }
}
