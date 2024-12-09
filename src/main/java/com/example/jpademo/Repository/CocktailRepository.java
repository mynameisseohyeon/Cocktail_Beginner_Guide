package com.example.jpademo.Repository;

import com.example.jpademo.Entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    // 이름으로 검색
    List<Cocktail> findByNameContaining(String keyword);

    // 가격으로 검색
    public List<Cocktail> findByPriceRangeLessThanEqual(int maxPrice);
    public List<Cocktail> findByPriceRangeGreaterThanEqualAndPriceRangeLessThan(int minPrice, int maxPrice);
    public List<Cocktail> findByPriceRangeGreaterThanEqual(int minPrice);

}
