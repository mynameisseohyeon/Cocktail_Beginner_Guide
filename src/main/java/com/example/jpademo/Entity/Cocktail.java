package com.example.jpademo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Entity
@Table(name = "cocktail")
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String name; // 칵테일 이름

    @Column(nullable = false)
    private int abv; // 도수

    private String taste; // 칵테일 맛
    private int ageGroup; // 연령대
    private String snacks; // 안주
    private int priceRange; // 가격
    private String cocktailInfo; // 정보
    private String image; // 이미지
    private String base;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingIdx")
    private List<Ingredient> ingredients = new ArrayList<>();

    @Column(nullable = false)
    private int volume; // 칵테일 ml

    @Column(name = "cocktail_idx")
    private Long cocktailIdx; // user 엔터티와 OneToMany 관계

    @ManyToMany(mappedBy = "selectedCocktails")
    private List<Calculate> calculatesWithSelection;

    @ManyToMany(mappedBy = "recommendedCocktails")
    private List<Calculate> calculatesWithRecommendation;

//    @OneToMany(mappedBy = "cocktail", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Ingredient> Ingredients;

    // 즐겨찾기 (선호하는 칵테일을 즐겨찾기 - user 테이블과의 join)
//    @OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY)
//    private List<User> users;
}

