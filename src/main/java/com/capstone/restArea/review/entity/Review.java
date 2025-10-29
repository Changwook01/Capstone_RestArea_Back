package com.capstone.restArea.review.entity;

import com.capstone.restArea.config.BaseEntity;
import com.capstone.restArea.foodmenu.entity.FoodMenu;
import com.capstone.restArea.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@NoArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @Column(nullable = false)
    private Integer rating; // 1 ~ 5점

    @Column(length = 2000)
    private String content; // 리뷰 내용

    // 관계 설정: 이 리뷰는 하나의 메뉴에 속합니다 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private FoodMenu foodMenu;

    // 관계 설정: 이 리뷰는 한 명의 사용자가 작성합니다 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Member member;
}