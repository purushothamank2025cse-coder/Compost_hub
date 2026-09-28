package com.example.composthub.service;

import com.example.composthub.model.ProcessingBatch;
import com.example.composthub.model.Inventory;
import com.example.composthub.repository.ProcessingBatchRepository;
import com.example.composthub.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.time.LocalDate;

@Service
public class ProcessingBatchService {
    private final ProcessingBatchRepository repository;
    private final InventoryRepository inventoryRepository;

    public ProcessingBatchService(ProcessingBatchRepository repository, InventoryRepository inventoryRepository) {
        this.repository = repository;
        this.inventoryRepository = inventoryRepository;
    }

    public List<ProcessingBatch> findAll() {
        return repository.findAll();
    }

    public ProcessingBatch findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProcessingBatch not found: " + id));
    }

    public ProcessingBatch save(ProcessingBatch entity) {
        return repository.save(entity);
    }

    @Transactional
    public ProcessingBatch complete(Long id) {
        ProcessingBatch batch = findById(id);
        if ("Completed".equalsIgnoreCase(batch.getStatus())) {
            return batch;
        }
        batch.setStatus("Completed");
        batch.setCompletionDate(LocalDate.now());
        ProcessingBatch saved = repository.save(batch);
        if (saved.getOutputQuantity() != null && saved.getOutputQuantity().signum() > 0) {
            Inventory stock = new Inventory();
            stock.setName("Compost batch " + saved.getId());
            stock.setProductType("Organic Compost Fertilizer");
            stock.setUnit("kg");
            stock.setQuantity(saved.getOutputQuantity());
            stock.setStatus("Available");
            inventoryRepository.save(stock);
        }
        return saved;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
