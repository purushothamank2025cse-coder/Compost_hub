package com.example.composthub.service;

import com.example.composthub.model.CustomerInvoice;
import com.example.composthub.repository.CustomerInvoiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerInvoiceService {
    private final CustomerInvoiceRepository repository;

    public CustomerInvoiceService(CustomerInvoiceRepository repository) {
        this.repository = repository;
    }

    public List<CustomerInvoice> findAll() {
        return repository.findAll();
    }

    public CustomerInvoice findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CustomerInvoice not found: " + id));
    }

    public CustomerInvoice save(CustomerInvoice entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
