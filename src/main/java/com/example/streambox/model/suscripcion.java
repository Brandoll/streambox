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
    private com.example.streambox.model.cliente cliente; // Relación con el cliente.

    @ManyToOne
    @JoinColumn(name = "cuenta_plataforma_id", nullable = false)
    private cuentaPlataforma cuentaPlataforma; // Relación con la cuenta de plataforma.

    @Column(nullable = false)
    private LocalDate fechaInicio; // Fecha de inicio de la suscripción.

    @Column(nullable = false)
    private LocalDate fechaFin; // Fecha de fin de la suscripción.

    @Column(nullable = false)
    private LocalDate fechaPago; // Fecha en que se realizó el último pago.

    @Column(nullable = false, length = 20)
    private String estado; // Estado de la suscripción (ACTIVA, VENCIDA, CANCELADA).

    @Column(nullable = false)
    private Double monto; // Monto total a pagar por la suscripción.

    @Column(nullable = true)
    private Double descuento; // Descuento aplicado, si existe.

    @Column(length = 255)
    private String observaciones; // Notas adicionales sobre la suscripción.

    @Column(nullable = true)
    private Integer numeroUsuarios; // Número de usuarios que comparten la suscripción.

    @Column(nullable = true)
    private Boolean renovacionAutomatica; // Indica si la suscripción se renueva automáticamente.

    @Column(nullable = true)
    private String metodoPago; // Método utilizado para el pago (e.g., Tarjeta, PayPal).
}
