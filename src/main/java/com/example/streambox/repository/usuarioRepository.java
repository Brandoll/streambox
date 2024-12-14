package com.example.streambox.repository;

import com.example.streambox.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long> {
    // Método para buscar un usuario por su username
    usuario findByUsername(String username);
}
