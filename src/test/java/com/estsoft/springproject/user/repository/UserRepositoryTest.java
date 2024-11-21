//package com.estsoft.springproject.user.repository;
//
//import com.estsoft.springproject.user.domain.Users;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//
//@DataJpaTest
//class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private Users getUser() {
//        String email = "email@email.com";
//        String password = "test123";
//        return new Users(email, password);
//    }
//
//    // 사용자 이메일로 조회 기능
//    @Test
//    public void testFindByMail() {
//        // given : 사용자 정보 저장
//        Users user = getUser();
//        Users savedUser = userRepository.save(user);
//
//        // when : 저장된 사용자 조회
//        Users saved = userRepository.save(user);
//
//        // then : 이메일이 일치하는지 확인
//        assertThat(saved.getEmail(), is(savedUser.getEmail()));
//    }
//
//    // 사용자 저장 기능
//    @Test
//    public void testSaveUser() {
//        // given : 사용자 정보 저장
//        Users user = getUser();
//
//        // when : 저장된 사용자 반환
//        Users savedUser = userRepository.save(user);
//
//        // then : 저장된 사용자 정보 확인
//        assertThat(savedUser.getEmail(), is(user.getEmail()));
//        assertThat(savedUser.getPassword(), is(user.getPassword()));
//    }
//
//    // 사용자 전체 조회 기능
////    @Test
////    public void testFindAll() {
////        // given : 사용자 정보 저장
////        Users user1 = getUser();
////        Users user2 = new Users("another@email.com", "password123");
////
////        userRepository.save(user1);
////        userRepository.save(user2);
////
////        // when : 전체 사용자 조회
////        Iterable<Users> users = userRepository.findAll();
////
////        // then
////        assertThat(users, hasSize(2));
////    }
//}
