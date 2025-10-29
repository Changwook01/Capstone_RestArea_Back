package com.capstone.restArea.member.entity;

import com.capstone.restArea.config.BaseEntity;
import com.capstone.restArea.foodmenu.entity.FoodMenu;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email; // 로그인 ID

    @Column(nullable = false)
    private String password; // 암호화된 비밀번호

    @Column(nullable = false, unique = true)
    private String nickname; // 사용자 닉네임

    // 관계 설정: '즐겨찾기' (사용자와 메뉴 간 N:M 다대다 관계)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_favorites", // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "user_id"), // User 측 외래 키
            inverseJoinColumns = @JoinColumn(name = "menu_id") // FoodMenu 측 외래 키
    )
    private Set<FoodMenu> favoriteMenus = new HashSet<>();
}
