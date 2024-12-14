package com.example.streambox.controller;

import com.example.streambox.model.plataforma;
import com.example.streambox.service.plataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plataformas")
public class plataformaController {

    @Autowired
    private plataformaService plataformaService;

    // Obtener la lista de todas las plataformas
    @GetMapping
    public List<plataforma> getAllPlataformas() {
        return plataformaService.getPlataformas();
    }

    // Obtener una plataforma por su id
    @GetMapping("/{id}")
    public ResponseEntity<plataforma> getPlataformaById(@PathVariable Long id) {
        plataforma plataforma = plataformaService.getPlataformaById(id);
        if (plataforma != null) {
            return ResponseEntity.ok(plataforma);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva plataforma
    @PostMapping
    public ResponseEntity<?> createPlataforma(@RequestBody plataforma plataforma) {
        if (plataforma.getNombre() == null || plataforma.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre es obligatorio");
        }
        plataforma createdPlataforma = plataformaService.createPlataforma(plataforma);
        return ResponseEntity.status(201).body(createdPlataforma);
    }


    // Actualizar una plataforma existente
    @PutMapping("/{id}")
    public ResponseEntity<plataforma> updatePlataforma(@PathVariable Long id, @RequestBody plataforma plataforma) {
        plataforma updatedPlataforma = plataformaService.updatePlataforma(id, plataforma);
        if (updatedPlataforma != null) {
            return ResponseEntity.ok(updatedPlataforma);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una plataforma por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlataforma(@PathVariable Long id) {
        plataforma plataforma = plataformaService.getPlataformaById(id);
        if (plataforma != null) {
            plataformaService.deletePlataforma(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
