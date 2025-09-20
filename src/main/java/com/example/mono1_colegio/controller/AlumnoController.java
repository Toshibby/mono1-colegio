package com.example.mono1_colegio.controller;

import com.example.mono1_colegio.entity.Alumno;
import com.example.mono1_colegio.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public  AlumnoController(AlumnoService alumnoService){
         this.alumnoService= alumnoService;
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> listarAlumnos(){
        List<Alumno> alumnos=alumnoService.listarAlumnos();
        return ResponseEntity.ok(alumnos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obetenerAlumno(@PathVariable Long id ){
        return alumnoService.obtenerAlumnoPorId(id).map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno){
        Alumno guardado =alumnoService.guardarAlumno(alumno);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        try {
            Alumno actualizado = alumnoService.actualizarAlumno(id, alumno);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }



}
