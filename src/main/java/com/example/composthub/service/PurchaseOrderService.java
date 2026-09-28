package com.example.composthub.service;

import com.example.composthub.model.PurchaseOrder;
import com.example.composthub.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

    public PurchaseOrder findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseOrder not found: " + id));
    }

    public PurchaseOrder save(PurchaseOrder entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
