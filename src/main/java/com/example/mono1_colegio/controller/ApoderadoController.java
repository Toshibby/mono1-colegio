package com.example.mono1_colegio.controller;

import com.example.mono1_colegio.entity.Apoderado;
import com.example.mono1_colegio.service.ApoderadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apoderados")
public class ApoderadoController {

    private final ApoderadoService apoderadoService;

    public  ApoderadoController(ApoderadoService apoderadoService){
        this.apoderadoService= apoderadoService;
    }

    @GetMapping
    public ResponseEntity<List<Apoderado>> listarApoderados(){
        List<Apoderado> apoderados= apoderadoService.listarApoderados();
        return ResponseEntity.ok(apoderados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apoderado> obtenerApoderado(@PathVariable Long id){
        return apoderadoService.obetenerApoderadoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Apoderado> crearApoderado(@RequestBody Apoderado apoderado){
        Apoderado guardado= apoderadoService.guardarApoderado(apoderado);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Apoderado> actualizarApoderado(@PathVariable Long id, @RequestBody Apoderado apoderado){
        try{
            Apoderado actualizado=apoderadoService.actualizarApoderado(id, apoderado);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e){
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> eliminarApoderado(@PathVariable Long id){
        apoderadoService.eliminarApoderado(id);
        return ResponseEntity.noContent().build();
    }

}
