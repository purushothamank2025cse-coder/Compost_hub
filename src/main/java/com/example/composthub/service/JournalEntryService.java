package com.example.composthub.service;

import com.example.composthub.model.JournalEntry;
import com.example.composthub.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JournalEntryService {
    private final JournalEntryRepository repository;

    public JournalEntryService(JournalEntryRepository repository) {
        this.repository = repository;
    }

    public List<JournalEntry> findAll() {
        return repository.findAll();
    }

    public JournalEntry findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("JournalEntry not found: " + id));
    }

    public JournalEntry save(JournalEntry entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
