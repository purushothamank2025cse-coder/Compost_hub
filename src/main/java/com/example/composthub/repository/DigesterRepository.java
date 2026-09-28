package com.example.composthub.repository;

import com.example.composthub.model.Digester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigesterRepository extends JpaRepository<Digester, Long> {
}
