package com.example.streambox.controller;

import com.example.streambox.model.suscripcion;
import com.example.streambox.service.suscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class suscripcionController {

    @Autowired
    private suscripcionService suscripcionService;

    // Obtener la lista de todas las suscripciones
    @GetMapping
    public List<suscripcion> getAllSuscripciones() {
        return suscripcionService.getSuscripciones();
    }

    // Obtener una suscripción por su id
    @GetMapping("/{id}")
    public ResponseEntity<suscripcion> getSuscripcionById(@PathVariable Long id) {
        suscripcion suscripcion = suscripcionService.getSuscripcionById(id);
        if (suscripcion != null) {
            return ResponseEntity.ok(suscripcion);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva suscripción
    @PostMapping
    public suscripcion createSuscripcion(@RequestBody suscripcion suscripcion) {
        return suscripcionService.createSuscripcion(suscripcion);
    }

    // Actualizar una suscripción existente
    @PutMapping("/{id}")
    public ResponseEntity<suscripcion> updateSuscripcion(@PathVariable Long id, @RequestBody suscripcion suscripcion) {
        suscripcion updatedSuscripcion = suscripcionService.updateSuscripcion(id, suscripcion);
        if (updatedSuscripcion != null) {
            return ResponseEntity.ok(updatedSuscripcion);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una suscripción por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuscripcion(@PathVariable Long id) {
        suscripcion suscripcion = suscripcionService.getSuscripcionById(id);
        if (suscripcion != null) {
            suscripcionService.deleteSuscripcion(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
