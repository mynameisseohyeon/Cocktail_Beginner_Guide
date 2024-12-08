package com.example.jpademo.Repository;

import com.example.jpademo.Entity.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculateRepository extends JpaRepository<Calculate, Long> {
}
