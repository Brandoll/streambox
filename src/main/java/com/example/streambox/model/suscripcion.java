package com.example.streambox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "suscripcion")
public class suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cuenta_plataforma_id", nullable = false)
    private cuentaPlataforma cuentaPlataforma;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = true)
    private LocalDate fechaPago;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = true)
    private Double descuento;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @Column(nullable = true)
    private Integer numeroUsuarios;

    @Column(nullable = true)
    private Boolean renovacionAutomatica;

    @Column(length = 255)
    private String observaciones;
}
