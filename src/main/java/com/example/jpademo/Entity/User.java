package com.example.jpademo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User { // 해당 user 엔터티에서는 도수 계산 시 사용자에게 주량을 입력받고 주량에 맞는 칵테일 조합을 추천

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    // eamil
    @Column
    private String email;

    // pw
    @Column
    private String pw;

    // 사용자 닉네임
    @Column
    private String userName;

    // 나이
    @Column
    private int age;

    // 칵테일 리스트
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cocktail_idx")
    @JsonIgnore
    private List<Cocktail> cocktailList;

}