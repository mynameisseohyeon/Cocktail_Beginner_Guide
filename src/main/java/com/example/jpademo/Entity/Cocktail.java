package com.example.jpademo.Entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private int volume; // 칵테일 ml

    @Column(name = "cocktail_idx")
    private Long cocktailIdx; // user 엔터티와 OneToMany 관계

    @ManyToMany(mappedBy = "selectedCocktails")
    private List<Calculate> calculatesWithSelection;

    @ManyToMany(mappedBy = "recommendedCocktails")
    private List<Calculate> calculatesWithRecommendation;
}
