package com.example.jpademo.Service;

import com.example.jpademo.Entity.CocktailDTO;

import java.util.List;

public interface CocktailService {
    List<CocktailDTO> findAll();
    CocktailDTO findById(long idx);
    void save(CocktailDTO cocktail);
    void deleteById(long idx);
}
