//package com.estsoft.springproject.user.service;
//
//import com.estsoft.springproject.user.domain.Users;
//import com.estsoft.springproject.user.domain.dto.AddUserRequest;
//import com.estsoft.springproject.user.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//    @InjectMocks
//    UserService userService;
//
//    @Mock
//    UserRepository repository;
//
//    @Spy
//    BCryptPasswordEncoder encoder;
//
//    @Test
//    public void testSave() {
//        // given :
//        String email = "mock_email";
//        String rawPassword = "mock_password";
//        encoder.encode(rawPassword);
//        AddUserRequest user = new AddUserRequest(email, rawPassword);
//
//        doReturn(rawPassword).when(encoder).encode(rawPassword);
//
//        // when : 회원가입 기능 - 사용자 정보 저장
//        Users returnSaved = userService.save(user);
//
//        // then
//        assertThat(returnSaved.getEmail(), is(email));
//
//        verify(repository, times(1)).save(any());
//        verify(encoder, times(2)).encode(any());
//        //
//    }
//
//}