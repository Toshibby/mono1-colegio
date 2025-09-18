package com.example.mono1_colegio.repository;

import com.example.mono1_colegio.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
