package com.example.mono1_colegio.service.impl;

import com.example.mono1_colegio.entity.Apoderado;
import com.example.mono1_colegio.repository.ApoderadoRepository;
import com.example.mono1_colegio.service.ApoderadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApoderadoServiceImpl implements ApoderadoService {

    private final ApoderadoRepository apoderadoRepository;

    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository){
        this.apoderadoRepository =apoderadoRepository;
    }

    public List<Apoderado> listarApoderados(){
        return apoderadoRepository.findAll();
    }

    public Optional<Apoderado> obetenerApoderadoPorId(Long id){
        return apoderadoRepository.findById(id);
    }

    public Apoderado guardarApoderado(Apoderado apoderado){
        return apoderadoRepository.save(apoderado);
    }

    public Apoderado actualizarApoderado(Long id, Apoderado apoderado){
        return apoderadoRepository.findById(id)
                .map(a -> {
                    a.setDni(apoderado.getDni());
                    a.setNombre(apoderado.getNombre());
                    a.setApellido(apoderado.getApellido());
                    a.setEmail(apoderado.getEmail());
                    a.setTelefono(apoderado.getTelefono());
                    a.setDireccion(apoderado.getDireccion());
                    a.setRuc(apoderado.getRuc());
                    a.setEstado(apoderado.getEstado());
                    return apoderadoRepository.save(a);
                })
                .orElseThrow(()-> new RuntimeException("Apoderado no encontrado"));
    }

    public void eliminarApoderado(Long id){
        apoderadoRepository.deleteById(id);
    }

}
