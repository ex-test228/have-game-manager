package com.example.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.app.entity.Expansion;
import com.example.app.service.ExpansionService;

import java.util.List;
import java.util.Optional;

@RestController // このクラスがRESTコントローラであることを示す
@RequestMapping("/api/Expansions") // ベースパスを設定
public class ExpansionController {

    private final ExpansionService ExpansionService;

    public ExpansionController(ExpansionService ExpansionService) {
        this.ExpansionService = ExpansionService;
    }

    @GetMapping // GET /api/Expansions
    public List<Expansion> getAllExpansions() {
        return ExpansionService.getAllExpansions();
    }

    @GetMapping("/{id}") // GET /api/Expansions/{id}
    public ResponseEntity<Expansion> getExpansionById(@PathVariable Long id) {
        Optional<Expansion> Expansion = ExpansionService.getExpansionById(id);
        return Expansion.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping // POST /api/Expansions
    public ResponseEntity<Expansion> createExpansion(@RequestBody Expansion Expansion) {
        Expansion createdExpansion = ExpansionService.createExpansion(Expansion);
        return new ResponseEntity<>(createdExpansion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // PUT /api/Expansions/{id}
    public ResponseEntity<Expansion> updateExpansion(@PathVariable Long id, @RequestBody Expansion ExpansionDetails) {
        try {
            Expansion updatedExpansion = ExpansionService.updateExpansion(id, ExpansionDetails);
            return ResponseEntity.ok(updatedExpansion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}") // DELETE /api/Expansions/{id}
    public ResponseEntity<Void> deleteExpansion(@PathVariable Long id) {
        try {
            ExpansionService.deleteExpansion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}