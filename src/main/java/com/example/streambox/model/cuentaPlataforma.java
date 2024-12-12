package com.example.streambox.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cuenta_plataforma")
public class cuentaPlataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String correo; // Correo asociado a la cuenta.

    @Column(nullable = false, length = 100)
    private String contraseña; // Contraseña de la cuenta.

    @Column(nullable = false)
    private Boolean estado; // Activo o inactivo.

    @Column(length = 255)
    private String observaciones; // Notas adicionales sobre la cuenta.

    @ManyToOne
    @JoinColumn(name = "plataforma_id", nullable = false)
    private Plataforma plataforma; // Relación con la plataforma asociada.

    @OneToMany(mappedBy = "cuentaPlataforma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Suscripcion> suscripciones; // Relación con las suscripciones de esta cuenta.
}
