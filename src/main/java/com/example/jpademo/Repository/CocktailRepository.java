package com.example.jpademo.Repository;

import com.example.jpademo.Entity.Cocktail;
import com.example.jpademo.Entity.CocktailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    List<CocktailDTO> findByNameContaining(String keyword);
}
