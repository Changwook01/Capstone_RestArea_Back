package com.capstone.restArea.config;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 1. 이 클래스가 엔티티의 공통 속성을 정의하는 부모 클래스임을 명시
@EntityListeners(AuditingEntityListener.class) // 2. JPA Auditing 기능을 활성화
public abstract class BaseEntity {

    @CreatedDate // 3. 엔티티 생성 시 자동으로 날짜 저장
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // 4. 엔티티 수정 시 자동으로 날짜 저장
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @CreatedBy // 5. 엔티티 생성 시 자동으로 생성자 저장
    @Column(name = "created_by", updatable = false)
    private String createdBy; // 생성자 (예: 사용자 ID)

    @LastModifiedBy // 6. 엔티티 수정 시 자동으로 수정자 저장
    @Column(name = "updated_by")
    private String updatedBy; // 수정자 (예: 사용자 ID)
}
