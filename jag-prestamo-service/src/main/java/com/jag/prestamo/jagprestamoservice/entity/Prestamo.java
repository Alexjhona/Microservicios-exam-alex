package com.jag.prestamo.jagprestamoservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long id;

    private Long usuarioId;
    private Long libroId;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    private Boolean devuelto;
}
