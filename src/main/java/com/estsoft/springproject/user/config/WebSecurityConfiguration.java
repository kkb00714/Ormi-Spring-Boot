package com.estsoft.springproject.user.config;

import com.estsoft.springproject.user.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class WebSecurityConfiguration {
    private final UserDetailService userDetailService;

    public WebSecurityConfiguration(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    // ignore, 특정 페이지로 접속 시 로그인 페이지로 리다이렉션 하지 않음.
    public WebSecurityCustomizer ignore() {
        return webSecurity -> webSecurity.ignoring()
                .requestMatchers("/static/**", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html"); // static 하위 html 페이지에 접근 시 로그인하지 않음.

    }

    // 패스워드 암호화 방식 정의 - 패스워드를 암호화 할 수 있음. (Spring Security에서 제공)
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 특정 요청에 대한 보안 구성
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                custom -> custom.requestMatchers("/login", "/signup", "/user").permitAll()
                        // .requestMatchers("/articles/**").hasRole("ADMIN") // ROLE_ADMIN 만 접근하도록
//                        .anyRequest().authenticated()
                        .anyRequest().permitAll()
                )
                // 3) 인증, 인가 설정
                /*
                .requestMatchers("/login", "/signup", "/user").permitAll()
                .requestMatchers("/api/external").hasRole("admin") // 인가
                .anyRequest().authenticated()
                 */

                //4) 폼 기반 로그인 설정
                // 기본 로그인 url 설정 및 성공 시 리다이렉션 페이지 설정
                .formLogin(custom -> custom.loginPage("/login")
                        .defaultSuccessUrl("/articles"))
//                .loginPage("/login")
                // 로그인 페이지
//                .defaultSuccessUrl("/articles") // 로그인을 성공했을 때 리다이렉션 URL

                // 5) 로그아웃 설정
                .logout(custom -> custom.logoutSuccessUrl("/login")
                        .invalidateHttpSession(true))
//                .logoutSuccessUrl("/login")
//                // 로그아웃 성공하면 연결될 페이지
//                .invalidateHttpSession(true) // 로그아웃 후 해당 세션을 제거할 것인지 (제거 - true)

                // 6) csrf 활성화/비활성화 , 스프링에서는 default가 활성화.
                .csrf(custom -> custom.disable())
                .build();
    }

    // 7) 인증관리자 관련 설정  => 삭제 가능! (default로 되어있기 때문)
    /*
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)  // UserDetailsService 구현체
                .passwordEncoder(bCryptPasswordEncoder) // 패스워드 인코더로 사용할 빈
                .and()
                .build();
    }
    */

}
