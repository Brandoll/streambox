package com.example.streambox.repository;

import com.example.streambox.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<cliente, Long> {
}
