package com.example.composthub.service;

import com.example.composthub.model.BudgetLine;
import com.example.composthub.repository.BudgetLineRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetLineService {
    private final BudgetLineRepository repository;

    public BudgetLineService(BudgetLineRepository repository) {
        this.repository = repository;
    }

    public List<BudgetLine> findAll() {
        return repository.findAll();
    }

    public BudgetLine findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BudgetLine not found: " + id));
    }

    public BudgetLine save(BudgetLine entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
