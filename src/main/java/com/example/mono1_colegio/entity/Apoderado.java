package com.example.mono1_colegio.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Apoderado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApoderado;

    private String dni;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String direccion;

    private String ruc;

    private Boolean estado;

    private LocalDate createdAt;

    @OneToMany
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

}
