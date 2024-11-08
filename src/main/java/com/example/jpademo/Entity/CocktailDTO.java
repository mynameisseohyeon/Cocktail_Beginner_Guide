package com.example.jpademo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CocktailDTO {

    private Long idx;

    private String name; // 칵테일 이름
    private String abv; // 도수
    private String taste; // 칵테일 맛
    private String ageGroup; // 연령대
    private String snacks; // 안주
    private String priceRange; // 가격대
    private String cocktailInfo; // 칵테일 정보
    private String image; // 칵테일 이미지

}