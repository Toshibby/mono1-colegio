package com.example.mono1_colegio.service.impl;

import com.example.mono1_colegio.entity.Alumno;
import com.example.mono1_colegio.repository.AlumnoRepository;
import com.example.mono1_colegio.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository= alumnoRepository;
    }

    @Override
    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> obtenerAlumnoPorId(Long id){
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno guardarAlumno (Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno actualizarAlumno(Long id, Alumno alumno){
        return alumnoRepository.findById(id).map(
                a->{
                    a.setDni(alumno.getDni());
                    a.setNombre(alumno.getNombre());
                    a.setApellido(alumno.getApellido());
                    a.setFechaNacimiento(alumno.getFechaNacimiento());
                    a.setDireccion(alumno.getDireccion());
                    a.setTelefono(alumno.getTelefono());
                    return alumnoRepository.save(a);
                }
        ).orElseThrow(()-> new RuntimeException("Alumno no encontrado"));
    }

    @Override
    public void eliminarAlumno(Long id){
        alumnoRepository.deleteById(id);
    }

}
