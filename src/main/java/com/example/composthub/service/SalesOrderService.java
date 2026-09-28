package com.example.composthub.service;

import com.example.composthub.model.SalesOrder;
import com.example.composthub.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesOrderService {
    private final SalesOrderRepository repository;

    public SalesOrderService(SalesOrderRepository repository) {
        this.repository = repository;
    }

    public List<SalesOrder> findAll() {
        return repository.findAll();
    }

    public SalesOrder findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SalesOrder not found: " + id));
    }

    public SalesOrder save(SalesOrder entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
