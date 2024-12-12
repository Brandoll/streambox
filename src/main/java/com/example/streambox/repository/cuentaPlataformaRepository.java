package com.example.streambox.repository;

import com.example.streambox.model.cuentaPlataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cuentaPlataformaRepository extends JpaRepository<cuentaPlataforma, Long> {
}
