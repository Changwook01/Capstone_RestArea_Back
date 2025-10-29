package com.capstone.restArea.restArea.repository;

import com.capstone.restArea.restArea.entity.RestArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestAreaRepository extends JpaRepository<RestArea, Long> {
}