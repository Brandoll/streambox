package com.example.streambox.service;

import com.example.streambox.model.cuentaPlataforma;
import com.example.streambox.repository.cuentaPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cuentaPlataformaService {

    @Autowired
    private cuentaPlataformaRepository cuentaPlataformaRepository;

    // Obtener todas las cuentas de plataforma
    public List<cuentaPlataforma> getCuentasPlataforma() {
        return cuentaPlataformaRepository.findAll();
    }

    // Obtener una cuenta de plataforma por su id
    public cuentaPlataforma getCuentaPlataformaById(Long id) {
        Optional<cuentaPlataforma> cuenta = cuentaPlataformaRepository.findById(id);
        return cuenta.orElse(null); // Retorna null si no encuentra la cuenta
    }

    // Crear una nueva cuenta de plataforma
    public cuentaPlataforma createCuentaPlataforma(cuentaPlataforma cuenta) {
        return cuentaPlataformaRepository.save(cuenta);
    }

    // Actualizar una cuenta de plataforma existente
    public cuentaPlataforma updateCuentaPlataforma(Long id, cuentaPlataforma cuenta) {
        if (cuentaPlataformaRepository.existsById(id)) {
            cuenta.setId(id);
            return cuentaPlataformaRepository.save(cuenta);
        }
        return null; // Retorna null si la cuenta no existe
    }

    // Eliminar una cuenta de plataforma por su id
    public void deleteCuentaPlataforma(Long id) {
        cuentaPlataformaRepository.deleteById(id);
    }
}
