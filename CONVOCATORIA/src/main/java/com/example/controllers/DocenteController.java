package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.models.Docente;
import com.example.services.DocenteServices;

@RestController
@RequestMapping("/docente")
public class DocenteController {
    @Autowired
    private DocenteServices docenteService;

    @GetMapping
    public ResponseEntity<ArrayList<Docente>> getAll() {
        return ResponseEntity.ok(docenteService.getAll());
    }

    @PostMapping
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        return ResponseEntity.ok(docenteService.save(docente));
    }

    @PutMapping
    public ResponseEntity<Docente> update(@RequestBody Docente docente) {
        return ResponseEntity.ok(docenteService.update(docente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        docenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}