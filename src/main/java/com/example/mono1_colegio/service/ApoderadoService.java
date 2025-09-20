package com.example.mono1_colegio.service;

import com.example.mono1_colegio.entity.Apoderado;

import java.util.List;
import java.util.Optional;

public interface ApoderadoService {
    List<Apoderado> listarApoderados();

    Optional<Apoderado> obetenerApoderadoPorId(Long id);

    Apoderado guardarApoderado(Apoderado apoderado);

    Apoderado actualizarApoderado(Long id, Apoderado apoderado);

    void eliminarApoderado(Long id);

}
