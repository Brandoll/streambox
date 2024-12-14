package com.example.streambox.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "plataforma")
public class plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String urlOficial;

    @Column(nullable = false)
    private Double costoMensual;

    @Column(nullable = true, length = 50)
    private String categoria;

    @OneToMany(mappedBy = "plataforma", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita serializar las cuentas en las respuestas
    private List<cuentaPlataforma> cuentas;
}
