package com.example.jpademo.Service;

import com.example.jpademo.Entity.*;
import com.example.jpademo.Repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CocktailServiceImpl implements CocktailService{

    @Autowired
    private CocktailRepository cocktailRepository;

    @Override
    public List<CocktailDTO> findAll() {

        return cocktailRepository.findAll().stream()
                .map(v ->  Utils.toDTO(v))
                .collect(Collectors.toList());

    }

    @Override
    public CocktailDTO findById(long idx) {
        return cocktailRepository.findById(idx)
                .map(v ->  Utils.toDTO(v))
                .orElse(null);
    }

    @Override
    public void save(CocktailDTO cocktailDTO) {
        Cocktail cocktail =  Utils.toEntity(cocktailDTO);
        cocktailRepository.save(cocktail);
    }

    @Override
    public void deleteById(long idx) {
        cocktailRepository.deleteById(idx);
    }

    public List<CocktailDTO> findByKeyword(String keyword) {
        return cocktailRepository.findByNameContaining(keyword);
    }

}
