package com.example.composthub.service;

import com.example.composthub.model.Budget;
import com.example.composthub.repository.BudgetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository repository;

    public BudgetService(BudgetRepository repository) {
        this.repository = repository;
    }

    public List<Budget> findAll() {
        return repository.findAll();
    }

    public Budget findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found: " + id));
    }

    public Budget save(Budget entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
