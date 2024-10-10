package com.estsoft.example.springdemoproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
// @Entity만 덜렁 선언하면 에러.
// pk에 해당하는 @Id 컬럼이 있어야 함!
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id     // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id라는 필드의 값을 자동적으로 생성해줌.
    private Long id;

    // 필드와 매핑할 컬럼 이름 지정 및 컬럼 매핑
    // 지정하지 않으면 필드명으로 지정됨.
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "`desc`")
    private String desc;

    @Column(name = "created_at",
            updatable = false,
            columnDefinition = "datetime(3)")
    @CreatedDate
    private LocalDateTime createdAt;

    // CreatedDate 사용하지 않으려면 아래와 같은 코드가 있어야 함.
//    @PrePersist // Insert문에 해당되는 것이라고 생각하기
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//    }

    // Transient 는 DB 컬럼으로는 미존재하지만 entity class에서는 개발자가 사용할 필드임을 명시
    @Transient
    private String nickname;

    public String getName() {
        return this.name + "_( " + this.age + " )";
    }
}
