package com.example.composthub.service;

import com.example.composthub.model.VendorBill;
import com.example.composthub.repository.VendorBillRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorBillService {
    private final VendorBillRepository repository;

    public VendorBillService(VendorBillRepository repository) {
        this.repository = repository;
    }

    public List<VendorBill> findAll() {
        return repository.findAll();
    }

    public VendorBill findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("VendorBill not found: " + id));
    }

    public VendorBill save(VendorBill entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
