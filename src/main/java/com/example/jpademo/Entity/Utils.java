package com.example.jpademo.Entity;

public class Utils {
    public static  CocktailDTO toDTO(Cocktail entity) {
        return CocktailDTO.builder()
                .idx(entity.getIdx())
                .name(entity.getName())
                .abv(entity.getAbv())
                .taste(entity.getTaste())
                .ageGroup(entity.getAgeGroup())
                .snacks(entity.getSnacks())
                .priceRange(entity.getPriceRange())
                .cocktailInfo(entity.getCocktailInfo())
                .image(entity.getImage())
                .base(entity.getBase())
//                .ingredients(entity.getIngredients().stream()
//                        .map(Utils::toIngredientDTO)
//                        .toList())
                .build();
    }

    private static IngredientDTO toIngredientDTO(Ingredient entity) {
        return IngredientDTO.builder()
                .ingIdx(entity.getIngIdx())
                .name(entity.getName())
                .baseInfo(entity.getBaseInfo())
                .image(entity.getImage())
                .build();
    }

    public static Cocktail toEntity(CocktailDTO dto) {
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
                .base(dto.getBase())

//                .Ingredients(dto.getIngredients().stream()
//                        .map(Utils::toIngredientEntity)
//                        .toList())
                .build();
    }

    private static Ingredient toIngredientEntity(IngredientDTO dto) {
        return Ingredient.builder()
                .ingIdx(dto.getIngIdx())
                .name(dto.getName())
                .baseInfo(dto.getBaseInfo())
                .image(dto.getImage())
                .build();
    }
}
