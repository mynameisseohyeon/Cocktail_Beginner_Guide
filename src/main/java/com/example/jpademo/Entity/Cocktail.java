package com.example.jpademo.Entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String name; // 칵테일 이름
    private String abv; // 도수
    private String taste; // 칵테일 맛
    private String ageGroup; // 연령대
    private String snacks; // 안주
    private String priceRange; // 가격
    private String cocktailInfo; // 정보
    private String image; // 이미지
}
