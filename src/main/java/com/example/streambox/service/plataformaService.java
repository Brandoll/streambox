package com.example.streambox.service;

import com.example.streambox.model.plataforma;
import com.example.streambox.repository.plataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class plataformaService {

    @Autowired
    private plataformaRepository plataformaRepository;

    // Obtener todas las plataformas
    public List<plataforma> getPlataformas() {
        return plataformaRepository.findAll();
    }

    // Obtener una plataforma por su id
    public plataforma getPlataformaById(Long id) {
        Optional<plataforma> plataforma = plataformaRepository.findById(id);
        return plataforma.orElse(null); // Retorna null si no encuentra la plataforma
    }

    // Crear una nueva plataforma
    public plataforma createPlataforma(plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    // Actualizar una plataforma existente
    public plataforma updatePlataforma(Long id, plataforma plataforma) {
        if (plataformaRepository.existsById(id)) {
            plataforma.setId(id);
            return plataformaRepository.save(plataforma);
        }
        return null; // Retorna null si la plataforma no existe
    }

    // Eliminar una plataforma por su id
    public void deletePlataforma(Long id) {
        plataformaRepository.deleteById(id);
    }
}
