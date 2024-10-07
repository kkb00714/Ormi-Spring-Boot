package com.estsoft.springdemoproject.service;

import com.estsoft.springdemoproject.repository.Member;
import com.estsoft.springdemoproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    // public MemberService(MemberRepository repository) {  // DI 처리
    //     this.repository = repository;
    // }

    // Member 테이블의 모든 정보 가져오기
    public List<Member> getAllMembers() {
        return repository.findAll();
    }



}
