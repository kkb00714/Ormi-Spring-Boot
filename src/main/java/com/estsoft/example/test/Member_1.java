package com.estsoft.example.test;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member_1 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member_1")
    private List<Order> orders;
}
