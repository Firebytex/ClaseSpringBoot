package com.example.demo.controller;

import com.example.demo.dao.AprendizDAO;
import com.example.demo.entity.Aprendiz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aprendices")
public class AprendizApiController {

    private final AprendizDAO aprendizDAO;

    public AprendizApiController(AprendizDAO aprendizDAO) {
        this.aprendizDAO = aprendizDAO;
    }

    @GetMapping
    public List<Aprendiz> getAll() {
        return aprendizDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aprendiz> getById(@PathVariable Long id) {
        Aprendiz aprendiz = aprendizDAO.findById(id);
        return ResponseEntity.ok(aprendiz);
    }

    @PostMapping
    public ResponseEntity<Aprendiz> create(@RequestBody Aprendiz aprendiz) {
        Aprendiz saved = aprendizDAO.save(aprendiz);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aprendiz> update(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
        aprendiz.setId(id);
        Aprendiz updated = aprendizDAO.save(aprendiz);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        aprendizDAO.delete(id);
        return ResponseEntity.noContent().build();
    }
}