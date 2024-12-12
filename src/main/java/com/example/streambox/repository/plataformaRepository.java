package com.example.streambox.repository;

import com.example.streambox.model.plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface plataformaRepository extends JpaRepository<plataforma, Long> {
}
