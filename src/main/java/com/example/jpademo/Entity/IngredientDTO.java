package com.example.jpademo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {

    private Long ingIdx;

    private String name; // 정보
    private String baseInfo; // 이미지
    private String image; // 이미지
}
