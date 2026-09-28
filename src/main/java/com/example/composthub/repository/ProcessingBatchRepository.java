package com.example.composthub.repository;

import com.example.composthub.model.ProcessingBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingBatchRepository extends JpaRepository<ProcessingBatch, Long> {
}
