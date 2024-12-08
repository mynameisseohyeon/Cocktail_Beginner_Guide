package com.example.jpademo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ingredient")
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingIdx;

    private String name; // 이름
    private String baseInfo; // 정보
    private String image; // 이미지

//    @ManyToOne
//    @JoinColumn(name = "idx")
//    private Cocktail cocktail;

}
