package com.example.streambox.model;

import jakarta.persistence.*;
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
    private String nombre; // Nombre del cliente.

    @Column(nullable = false, length = 100)
    private String apellido; // Apellido del cliente.

    @Column(nullable = false, unique = true, length = 100)
    private String email; // Correo electrónico del cliente.

    @Column(nullable = true, length = 15)
    private String telefono; // Teléfono de contacto del cliente.

    @Column(nullable = true)
    private String tipoDocumento; // Tipo de documento de identidad (DNI, pasaporte, etc.).

    @Column(nullable = true, length = 20)
    private String numeroDocumento; // Número de documento de identidad.

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<suscripcion> suscripciones; // Relación con las suscripciones adquiridas por el cliente.


    @Column(nullable = true)
    private String observaciones; // Notas adicionales sobre el cliente (por ejemplo, solicitudes especiales).
}
