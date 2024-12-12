package com.example.streambox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String urlOficial; // URL oficial de la plataforma (e.g., netflix.com)

    @Column(nullable = false)
    private Double costoMensual; // Costo mensual de la plataforma en una moneda base.

    @Column(nullable = true, length = 50)
    private String categoria; // Tipo de plataforma (e.g., streaming, diseño, música).


    @OneToMany(mappedBy = "plataforma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<cuentaPlataforma> cuentas; // Relación con las cuentas de la plataforma.
}
