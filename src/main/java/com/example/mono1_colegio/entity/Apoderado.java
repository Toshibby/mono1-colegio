package com.example.mono1_colegio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @OneToMany(mappedBy = "apoderado", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Alumno> alumnos;
}
