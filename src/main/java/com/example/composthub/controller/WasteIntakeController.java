package com.example.composthub.controller;

import com.example.composthub.model.Digester;
import com.example.composthub.model.WasteIntake;
import com.example.composthub.service.DigesterService;
import com.example.composthub.service.WasteIntakeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compost")
public class WasteIntakeController {
    private final WasteIntakeService wasteService;
    private final DigesterService digesterService;

    public WasteIntakeController(WasteIntakeService wasteService, DigesterService digesterService) {
        this.wasteService = wasteService;
        this.digesterService = digesterService;
    }

    @GetMapping("/digesters")
    public List<Digester> digesters() {
        return digesterService.findAll();
    }

    @PostMapping("/digesters")
    @ResponseStatus(HttpStatus.CREATED)
    public Digester createDigester(@RequestBody Digester digester) {
        requireText(digester.getName(), "Digester name");
        if (digester.getStatus() == null || digester.getStatus().isBlank()) {
            digester.setStatus("Active");
        }
        return digesterService.save(digester);
    }

    @GetMapping("/intake")
    public List<WasteIntake> intake() {
        return wasteService.findAll();
    }

    @PostMapping("/intake")
    @ResponseStatus(HttpStatus.CREATED)
    public WasteIntake recordIntake(@RequestBody WasteIntake intake) {
        requireText(intake.getName(), "Intake reference");
        if (intake.getQuantity() == null || intake.getQuantity().signum() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (intake.getIntakeDate() == null) {
            intake.setIntakeDate(java.time.LocalDate.now());
        }
        if (intake.getStatus() == null || intake.getStatus().isBlank()) {
            intake.setStatus("Received");
        }
        return wasteService.save(intake);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(IllegalArgumentException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    private void requireText(String value, String label) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(label + " is required");
        }
    }

    public record ErrorResponse(String message) { }
}
