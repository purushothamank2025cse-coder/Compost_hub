package com.example.composthub.service;

import com.example.composthub.model.Contact;
import com.example.composthub.repository.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {
    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact not found: " + id));
    }

    public Contact save(Contact entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
