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

//    @Override
//    public List<CocktailDTO> findByPriceLessThanEqual(int maxPrice) {
//        return cocktailRepository.findByPriceRangeLessThanEqual(maxPrice).stream()
//                .map(Utils::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<CocktailDTO> findByPriceGreaterThanEqualAndLessThan(int minPrice, int maxPrice) {
//        return cocktailRepository.findByPriceRangeGreaterThanEqualAndPriceRangeLessThan(minPrice, maxPrice).stream()
//                .map(Utils::toDTO)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<CocktailDTO> findByPriceGreaterThanEqual(int minPrice) {
//        return cocktailRepository.findByPriceRangeGreaterThanEqual(minPrice).stream()
//                .map(Utils::toDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<CocktailDTO> filterBySelect(String price, String alcohol, String ageGroup) {
        List<Cocktail> cocktails = cocktailRepository.findAll(); // 모든 데이터를 먼저 조회

        // 가격대 필터링
        if (price != null) {
            switch (price) {
                case "under_10000":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getPriceRange() <= 10000)
                            .collect(Collectors.toList());
                    break;
                case "over_10000":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getPriceRange() > 10000 && c.getPriceRange() <= 20000)
                            .collect(Collectors.toList());
                    break;
                case "over_20000":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getPriceRange() > 20000 && c.getPriceRange() <= 30000)
                            .collect(Collectors.toList());
                    break;
                case "over_30000":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getPriceRange() > 30000 && c.getPriceRange() <= 40000)
                            .collect(Collectors.toList());
                    break;
                case "over_40000":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getPriceRange() > 40000)
                            .collect(Collectors.toList());
                    break;
            }
        }

        // 도수 필터링
        if (alcohol != null) {
            switch (alcohol) {
                case "under_10":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAbv() < 10)
                            .collect(Collectors.toList());
                    break;
                case "over_10":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAbv() >= 10 && c.getAbv() < 20)
                            .collect(Collectors.toList());
                    break;
                case "over_20":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAbv() >= 20 && c.getAbv() < 30)
                            .collect(Collectors.toList());
                    break;
                case "over_30":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAbv() >= 30 && c.getAbv() < 40)
                            .collect(Collectors.toList());
                    break;
                case "over_40":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAbv() >= 40)
                            .collect(Collectors.toList());
                    break;
            }
        }

        if (ageGroup != null) {
            switch (ageGroup) {
                case "over_age_20":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAgeGroup() >= 20 && c.getAgeGroup() < 30)
                            .collect(Collectors.toList());
                    break;
                case "over_age_30":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAgeGroup() >= 30 && c.getAgeGroup() < 40)
                            .collect(Collectors.toList());
                    break;
                case "over_age_40":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAgeGroup() >= 40 && c.getAgeGroup() < 50)
                            .collect(Collectors.toList());
                    break;
                case "over_age_50":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAgeGroup() >= 50 && c.getAgeGroup() < 60)
                            .collect(Collectors.toList());
                    break;
                case "over_age_60":
                    cocktails = cocktails.stream()
                            .filter(c -> c.getAgeGroup() >= 60 && c.getAgeGroup() < 70)
                            .collect(Collectors.toList());
                    break;
            }
        }

        return cocktails.stream()
                .map(Utils::toDTO) // 엔티티를 DTO로 변환
                .collect(Collectors.toList());
    }

}
