package com.example.jpademo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "calculate")
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calculate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 상태 (오늘 얼마나 마실 것인지)
    private int state; // 1. 몸 사릴래, 2. 자중, 3. 꽐라

    // 선택한 칵테일 (유저가 포함시키고 싶어 하는 칵테일)
    @ManyToMany
    @JoinTable(name = "selected_cocktails")
    private List<Cocktail> selectedCocktails;

    // 몇 잔을 마실 것인지
    private int numOfDrink;

    // 주량
    private int drinkCapacity;

    // 결과 : 추천된 칵테일 리스트
    @ManyToMany
    @JoinTable(name = "recommended_cocktails")
    private List<Cocktail> recommendedCocktails;
}
