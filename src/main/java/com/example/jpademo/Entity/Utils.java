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
                .build();
    }
}
