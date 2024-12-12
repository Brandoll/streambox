package com.example.streambox.controller;

import com.example.streambox.model.cuentaPlataforma;
import com.example.streambox.service.cuentaPlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas-plataforma")
public class cuentaPlataformaController {

    @Autowired
    private cuentaPlataformaService cuentaPlataformaService;

    // Obtener la lista de todas las cuentas de plataforma
    @GetMapping
    public List<cuentaPlataforma> getAllCuentasPlataforma() {
        return cuentaPlataformaService.getCuentasPlataforma();
    }

    // Obtener una cuenta de plataforma por su id
    @GetMapping("/{id}")
    public ResponseEntity<cuentaPlataforma> getCuentaPlataformaById(@PathVariable Long id) {
        cuentaPlataforma cuenta = cuentaPlataformaService.getCuentaPlataformaById(id);
        if (cuenta != null) {
            return ResponseEntity.ok(cuenta);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva cuenta de plataforma
    @PostMapping
    public cuentaPlataforma createCuentaPlataforma(@RequestBody cuentaPlataforma cuenta) {
        return cuentaPlataformaService.createCuentaPlataforma(cuenta);
    }

    // Actualizar una cuenta de plataforma existente
    @PutMapping("/{id}")
    public ResponseEntity<cuentaPlataforma> updateCuentaPlataforma(@PathVariable Long id, @RequestBody cuentaPlataforma cuenta) {
        cuentaPlataforma updatedCuenta = cuentaPlataformaService.updateCuentaPlataforma(id, cuenta);
        if (updatedCuenta != null) {
            return ResponseEntity.ok(updatedCuenta);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una cuenta de plataforma por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuentaPlataforma(@PathVariable Long id) {
        cuentaPlataforma cuenta = cuentaPlataformaService.getCuentaPlataformaById(id);
        if (cuenta != null) {
            cuentaPlataformaService.deleteCuentaPlataforma(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
