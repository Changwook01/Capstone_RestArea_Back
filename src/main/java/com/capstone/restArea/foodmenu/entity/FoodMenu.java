package com.capstone.restArea.foodmenu.entity;

import com.capstone.restArea.config.BaseEntity;
import com.capstone.restArea.restArea.entity.RestArea;
import com.capstone.restArea.review.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_menus")
@Getter
@NoArgsConstructor
public class FoodMenu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column(nullable = false)
    private String name; // 메뉴 이름 (예: "얼큰칼국수")

    private Integer price; // 가격 (예: 6000)

    @Column(length = 1000)
    private String description; // 메뉴 설명

    @Column(name = "image_url")
    private String imageUrl; // 메뉴 사진 URL

    @Column(name = "is_premium")
    private Boolean isPremium = false; // "프리미엄", "베스트" 태그 여부

    // 평균 평점 (리뷰가 달릴 때마다 업데이트)
    @Column(name = "average_rating")
    private Double averageRating = 0.0;

    // 관계 설정: 이 메뉴는 하나의 휴게소에 속합니다 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_area_id", nullable = false)
    private RestArea restArea;

    // 관계 설정: 이 메뉴는 여러 개의 리뷰를 가집니다 (1:N)
    @OneToMany(mappedBy = "foodMenu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}