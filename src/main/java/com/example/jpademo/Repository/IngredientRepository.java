package com.example.jpademo.Repository;

import com.example.jpademo.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
//    Optional<Object> findBybaseId(long idx);
}
