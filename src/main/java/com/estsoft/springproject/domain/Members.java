package com.estsoft.springproject.domain;

import jakarta.persistence.*;

@Entity
public class Members {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    // JoinColumn - FK 명세
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
}
