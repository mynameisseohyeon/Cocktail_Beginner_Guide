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

    @Override
    public List<CocktailDTO> findByKeyword(String keyword) {
        return cocktailRepository.findByNameContaining(keyword).stream()
                .map(Utils::toDTO) // 엔티티를 DTO로 변환
                .collect(Collectors.toList());
    }

    @Override
    public List<CocktailDTO> findByPriceLessThanEqual(int maxPrice) {
        return cocktailRepository.findByPriceRangeLessThanEqual(maxPrice).stream()
                .map(Utils::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CocktailDTO> findByPriceGreaterThanEqualAndLessThan(int minPrice, int maxPrice) {
        return cocktailRepository.findByPriceRangeGreaterThanEqualAndPriceRangeLessThan(minPrice, maxPrice).stream()
                .map(Utils::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CocktailDTO> findByPriceGreaterThanEqual(int minPrice) {
        return cocktailRepository.findByPriceRangeGreaterThanEqual(minPrice).stream()
                .map(Utils::toDTO)
                .collect(Collectors.toList());
    }
}
