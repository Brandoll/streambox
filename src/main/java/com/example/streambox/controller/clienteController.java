package com.example.streambox.controller;

import com.example.streambox.model.cliente;
import com.example.streambox.service.clienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {

    @Autowired
    private clienteService clienteService;

    // Obtener la lista de todos los clientes
    @GetMapping
    public List<cliente> getAllClientes() {
        return clienteService.getClientes();
    }

    // Obtener un cliente por su id
    @GetMapping("/{id}")
    public ResponseEntity<cliente> getClienteById(@PathVariable Long id) {
        cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo cliente
    @PostMapping
    public cliente createCliente(@RequestBody cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<cliente> updateCliente(@PathVariable Long id, @RequestBody cliente cliente) {
        cliente updatedCliente = clienteService.updateCliente(id, cliente);
        if (updatedCliente != null) {
            return ResponseEntity.ok(updatedCliente);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un cliente por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            clienteService.deleteCliente(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
