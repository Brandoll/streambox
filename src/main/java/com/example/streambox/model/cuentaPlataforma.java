package com.example.streambox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cuenta_plataforma")
public class cuentaPlataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false, length = 100)
    private String contraseña;

    @Column(nullable = false)
    private String estado; //CAMBIO 2.5.5

    @Column(length = 255)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "plataforma_id", nullable = false) // Relación obligatoria
    private plataforma plataforma;
}
