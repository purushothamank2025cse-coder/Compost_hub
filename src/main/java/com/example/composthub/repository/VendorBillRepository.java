package com.example.composthub.repository;

import com.example.composthub.model.VendorBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorBillRepository extends JpaRepository<VendorBill, Long> {
}
