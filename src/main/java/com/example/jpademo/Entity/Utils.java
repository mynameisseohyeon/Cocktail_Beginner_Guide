package com.example.jpademo.Entity;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static  CocktailDTO toDTO(Cocktail entity) {
        List<IngredientDTO> ingredientDTOS = entity.getIngredients().stream()
                .map(ingredient -> new IngredientDTO(
                        ingredient.getIngIdx(),
                        ingredient.getName(),
                        ingredient.getBaseInfo(),
                        ingredient.getImage()
                ))
                .collect(Collectors.toList());
        System.out.println(entity.getIngredients());

        return new CocktailDTO(
                entity.getIdx(),
                entity.getName(),
                entity.getAbv(),
                entity.getTaste(),
                entity.getAgeGroup(),
                entity.getSnacks(),
                entity.getPriceRange(),
                entity.getCocktailInfo(),
                entity.getImage(),
                ingredientDTOS,
                entity.getCocktailIdx()
        );
    }

    public static Cocktail toEntity(CocktailDTO dto) {
        List<Ingredient> ingredients = dto.getIngredients().stream()
                .map(ingredientDTO -> new Ingredient(
                        ingredientDTO.getIngIdx(),
                        ingredientDTO.getName(),
                        ingredientDTO.getBaseInfo(),
                        ingredientDTO.getImage()
                ))
                .collect(Collectors.toList());
        return Cocktail.builder()
                .idx(dto.getIdx())
                .name(dto.getName())
                .abv(dto.getAbv())
                .taste(dto.getTaste())
                .ageGroup(dto.getAgeGroup())
                .snacks(dto.getSnacks())
                .priceRange(dto.getPriceRange())
                .cocktailInfo(dto.getCocktailInfo())
                .image(dto.getImage())
                .build();
    }
}