package com.example.streambox.repository;

import com.example.streambox.model.suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface suscripcionRepository extends JpaRepository<suscripcion, Long> {
}
