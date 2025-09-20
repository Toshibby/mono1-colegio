package com.example.mono1_colegio.service;

import com.example.mono1_colegio.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<Alumno> listarAlumnos();

    Optional<Alumno> obtenerAlumnoPorId(Long id);

    Alumno guardarAlumno (Alumno alumno);

    Alumno actualizarAlumno(Long id, Alumno alumno);

    void eliminarAlumno(Long id);

}
