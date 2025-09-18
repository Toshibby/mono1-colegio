package com.example.mono1_colegio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    private  String dni;

    private String nombre;

    private  String Apellido;

    private LocalDate fechaNacimiento;

    private String direccion;

    private  String telefono;

    @ManyToOne
    @JoinColumn (name = "apoderado_id", nullable = false)
    private Apoderado apoderado;
}
