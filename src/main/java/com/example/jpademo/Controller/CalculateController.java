package com.example.jpademo.Controller;

import com.example.jpademo.Entity.Calculate;
import com.example.jpademo.Entity.Cocktail;
import com.example.jpademo.Entity.CocktailDTO;
import com.example.jpademo.Repository.CocktailRepository;
import com.example.jpademo.Service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @Autowired
    private CocktailRepository cocktailRepository;

    @GetMapping
    public String calculateForm(Model model) {
        // 모든 칵테일을 조회하여 모델에 추가
        List<Cocktail> cocktails = cocktailRepository.findAll();
        model.addAttribute("cocktails", cocktails);
        return "calculator";
    }

    @RequestMapping("/recommend")
    public String recommendCocktails(
            @RequestParam("drinkCapacity") int drinkCapacity,
            @RequestParam("numOfDrink") int numOfDrink,
            @RequestParam(value = "selectedCocktails", required = false) List<Long> selectedCocktailIds,
            Model model) {

        // 추천 로직 호출
        List<Cocktail> recommendedCocktails = calculateService.recommendCocktails(drinkCapacity, numOfDrink, selectedCocktailIds);

        // 추천된 칵테일 리스트를 모델에 추가
        model.addAttribute("recommendedCocktails", recommendedCocktails);

        return "recommendations";
    }
}
