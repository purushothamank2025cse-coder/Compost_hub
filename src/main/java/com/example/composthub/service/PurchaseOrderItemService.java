package com.example.composthub.service;

import com.example.composthub.model.PurchaseOrderItem;
import com.example.composthub.repository.PurchaseOrderItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderItemService {
    private final PurchaseOrderItemRepository repository;

    public PurchaseOrderItemService(PurchaseOrderItemRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrderItem> findAll() {
        return repository.findAll();
    }

    public PurchaseOrderItem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseOrderItem not found: " + id));
    }

    public PurchaseOrderItem save(PurchaseOrderItem entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
