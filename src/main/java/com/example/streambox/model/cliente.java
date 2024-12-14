package com.example.streambox.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = true, length = 15)
    private String telefono;

    @Column(nullable = true)
    private String tipoDocumento;

    @Column(nullable = true, length = 20)
    private String numeroDocumento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Evita serializar la relación para prevenir referencias circulares
    private List<suscripcion> suscripciones;

    @Column(nullable = true)
    private String observaciones;
}
