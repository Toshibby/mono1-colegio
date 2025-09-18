package com.example.mono1_colegio.repository;

import com.example.mono1_colegio.entity.Apoderado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoderadoRepository extends JpaRepository<Apoderado, Long> {
}
