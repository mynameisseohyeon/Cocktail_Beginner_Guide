package com.example.jpademo.Service;

import com.example.jpademo.Entity.Calculate;
import com.example.jpademo.Entity.Cocktail;
import com.example.jpademo.Repository.CalculateRepository;
import com.example.jpademo.Repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculateService {

    private final CocktailRepository cocktailRepository;
    private final CalculateRepository calculateRepository;

    public List<Cocktail> recommendCocktails(int drinkCapacity, int state) {
        // 소주 1잔 기준 알코올 소비량 (80ml * 0.16)
        double sojuAlcoholContent = drinkCapacity * 80 * 0.16;

        // 칵테일 리스트 가져오기
        List<Cocktail> allCocktails = cocktailRepository.findAll();

        // 상태에 따라 추천 전략 변경
        double stateMultiplier = switch (state) {
            case 1 -> 0.5; // 몸 사릴래: 50% 주량만 사용
            case 2 -> 1.0; // 자중: 정상 주량
            case 3 -> 1.5; // 꽐라: 150% 주량까지 허용
            default -> 1.0; // 기본값: 정상 주량
        };

        // 칵테일 추천 로직
        double adjustedAlcoholContent = sojuAlcoholContent * stateMultiplier;
        List<Cocktail> recommendedCocktails = allCocktails.stream()
                .filter(cocktail -> {
                    // 칵테일의 알코올 소비량 계산
                    double cocktailAlcoholContent = cocktail.getAbv() * 0.01 * cocktail.getVolume() * 0.8;
                    return cocktailAlcoholContent <= adjustedAlcoholContent;
                })
                .collect(Collectors.toList());

        // 추천된 칵테일 저장
        Calculate calculate = Calculate.builder()
                .drinkCapacity(drinkCapacity)
                .state(state)
                .recommendedCocktails(recommendedCocktails)
                .build();

        calculateRepository.save(calculate);


        return recommendedCocktails;
    }
}
