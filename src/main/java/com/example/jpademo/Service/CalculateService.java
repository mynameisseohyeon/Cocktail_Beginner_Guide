package com.example.jpademo.Service;

import com.example.jpademo.Entity.Calculate;
import com.example.jpademo.Entity.Cocktail;
import com.example.jpademo.Repository.CalculateRepository;
import com.example.jpademo.Repository.CocktailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculateService {

    private final CocktailRepository cocktailRepository;
    private final CalculateRepository calculateRepository;

    public List<Cocktail> recommendCocktails(int drinkCapacity, int state, List<Long> selectedCocktailIds) {
        System.out.println("주량 계산 시스템");

        // 소주 1잔 기준 알코올 소비량 (80ml * 0.16)
        double sojuAlcoholContent = drinkCapacity * 80 * 0.16;

        // 선택된 칵테일 로드
        List<Cocktail> selectedCocktails = selectedCocktailIds != null
                ? cocktailRepository.findAllById(selectedCocktailIds)
                : Collections.emptyList();

        // 선택된 칵테일의 총 알코올 소비량 계산
        double selectedCocktailsAlcoholContent = selectedCocktails.stream()
                .mapToDouble(cocktail -> cocktail.getAbv() * 0.01 * cocktail.getVolume() * 0.8)
                .sum();

        // 상태에 따른 주량 계산
        double stateMultiplier = switch (state) {
            case 1 -> 0.5; // 몸 사릴래: 50% 주량만 사용
            case 2 -> 1.0; // 자중: 정상 주량
            case 3 -> 1.5; // 꽐라: 150% 주량까지 허용
            default -> 1.0; // 기본값: 정상 주량
        };

        // 조정된 알코올 소비량 (사용자 주량 - 선택한 칵테일 알코올 소비량)
        double adjustedAlcoholContent = (sojuAlcoholContent * stateMultiplier) - selectedCocktailsAlcoholContent;

        if (adjustedAlcoholContent < 0) {
            throw new IllegalArgumentException("선택한 칵테일이 사용자의 주량을 초과합니다.");
        }

        // 모든 칵테일 가져오기
        List<Cocktail> allCocktails = cocktailRepository.findAll();

        // 칵테일 추천 로직
        List<Cocktail> recommendedCocktails = allCocktails.stream()
                .filter(cocktail -> {
                    // 칵테일의 알코올 소비량 계산
                    double cocktailAlcoholContent = cocktail.getAbv() * 0.01 * cocktail.getVolume() * 0.8;
                    return cocktailAlcoholContent <= adjustedAlcoholContent;
                })
                .filter(cocktail -> !selectedCocktails.contains(cocktail)) // 선택하지 않은 칵테일만 포함
                .collect(Collectors.toList());

        // 추천된 칵테일 저장
        Calculate calculate = Calculate.builder()
                .drinkCapacity(drinkCapacity)
                .state(state)
                .recommendedCocktails(recommendedCocktails)
                .selectedCocktails(selectedCocktails)
                .build();

        calculateRepository.save(calculate);

        return recommendedCocktails;
    }
}
