package com.example.jpademo.Service;

import com.example.jpademo.Entity.CocktailDTO;

import java.util.List;

public interface CocktailService {
    List<CocktailDTO> findAll();
    CocktailDTO findById(long idx);
    void save(CocktailDTO cocktail);
    void deleteById(long idx);
    List<CocktailDTO> findByKeyword(String keyword);

//    List<CocktailDTO> findByPriceLessThanEqual(int maxPrice);
//    List<CocktailDTO> findByPriceGreaterThanEqualAndLessThan(int minPrice, int maxPrice);
//    List<CocktailDTO> findByPriceGreaterThanEqual(int minPrice);

    List<CocktailDTO> filterBySelect(String price, String alcohol, String ageGroup);
}