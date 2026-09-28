package com.example.composthub.service;

import com.example.composthub.model.Digester;
import com.example.composthub.repository.DigesterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DigesterService {
    private final DigesterRepository repository;

    public DigesterService(DigesterRepository repository) {
        this.repository = repository;
    }

    public List<Digester> findAll() {
        return repository.findAll();
    }

    public Digester findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Digester not found: " + id));
    }

    public Digester save(Digester entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
