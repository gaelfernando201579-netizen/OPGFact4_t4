package com.ito.OPGFact4_t4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String nombre;

    @Column(name = "last_name", nullable = false)
    private String apellidos;

    @Column(name = "email_address", unique = true, nullable = false)
    private String email;

    private String posicion;
}
