package com.example.streambox.service;

import com.example.streambox.model.suscripcion;
import com.example.streambox.repository.suscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class suscripcionService {

    @Autowired
    private suscripcionRepository suscripcionRepository;

    // Obtener todas las suscripciones
    public List<suscripcion> getSuscripciones() {
        return suscripcionRepository.findAll();
    }

    // Obtener una suscripción por su id
    public suscripcion getSuscripcionById(Long id) {
        Optional<suscripcion> suscripcion = suscripcionRepository.findById(id);
        return suscripcion.orElse(null); // Retorna null si no encuentra la suscripción
    }

    // Crear una nueva suscripción
    public suscripcion createSuscripcion(suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    // Actualizar una suscripción existente
    public suscripcion updateSuscripcion(Long id, suscripcion suscripcion) {
        if (suscripcionRepository.existsById(id)) {
            suscripcion.setId(id);
            return suscripcionRepository.save(suscripcion);
        }
        return null; // Retorna null si la suscripción no existe
    }

    // Eliminar una suscripción por su id
    public void deleteSuscripcion(Long id) {
        suscripcionRepository.deleteById(id);
    }
}
