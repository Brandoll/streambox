package com.example.streambox.service;

import com.example.streambox.model.cliente;
import com.example.streambox.repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clienteService {

    @Autowired
    private clienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<cliente> getClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su id
    public cliente getClienteById(Long id) {
        Optional<cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null); // Retorna null si no encuentra el cliente
    }

    // Crear un nuevo cliente
    public cliente createCliente(cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public cliente updateCliente(Long id, cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null; // Retorna null si el cliente no existe
    }

    // Eliminar un cliente por su id
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
