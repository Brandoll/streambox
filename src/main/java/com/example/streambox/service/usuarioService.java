package com.example.streambox.service;

import com.example.streambox.model.usuario;
import com.example.streambox.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por su ID
    public usuario getUsuarioById(Long id) {
        Optional<usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null); // Retorna null si no encuentra el usuario
    }

    // Obtener un usuario por su nombre de usuario
    public usuario getUsuarioByUsername(String username) {
        return usuarioRepository.findByUsername(username); // Reutiliza el método del repositorio
    }

    // Crear un nuevo usuario
    public usuario createUsuario(usuario usuario) {
        // Si no se proporciona un rol, asignar 'USER' por defecto
        if (usuario.getRol() == null) {
            usuario.setRol("USER"); // Asignación predeterminada
        }
        return usuarioRepository.save(usuario);
    }

    // Actualizar un usuario existente
    public usuario updateUsuario(Long id, usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null; // Retorna null si el usuario no existe
    }

    // Eliminar un usuario por su ID
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
