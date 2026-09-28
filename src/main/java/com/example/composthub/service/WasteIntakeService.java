package com.example.composthub.service;

import com.example.composthub.model.WasteIntake;
import com.example.composthub.repository.WasteIntakeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WasteIntakeService {
    private final WasteIntakeRepository repository;

    public WasteIntakeService(WasteIntakeRepository repository) {
        this.repository = repository;
    }

    public List<WasteIntake> findAll() {
        return repository.findAll();
    }

    public WasteIntake findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WasteIntake not found: " + id));
    }

    public WasteIntake save(WasteIntake entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
