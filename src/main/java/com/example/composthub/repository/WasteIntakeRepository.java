package com.example.composthub.repository;

import com.example.composthub.model.WasteIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteIntakeRepository extends JpaRepository<WasteIntake, Long> {
}
