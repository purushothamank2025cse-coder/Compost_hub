package com.example.composthub.service;

import com.example.composthub.model.SalesOrderItem;
import com.example.composthub.repository.SalesOrderItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesOrderItemService {
    private final SalesOrderItemRepository repository;

    public SalesOrderItemService(SalesOrderItemRepository repository) {
        this.repository = repository;
    }

    public List<SalesOrderItem> findAll() {
        return repository.findAll();
    }

    public SalesOrderItem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SalesOrderItem not found: " + id));
    }

    public SalesOrderItem save(SalesOrderItem entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
