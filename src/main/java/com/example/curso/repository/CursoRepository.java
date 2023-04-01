package com.example.curso.repository;

import com.example.curso.entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
    List<CursoEntity> findByNome(String nome);
    List<CursoEntity> findByCategoria(String categoria);
    List<CursoEntity> findByOrderByDataCriacaoDesc();
    List<CursoEntity> findByOrderByAvaliacaoDesc();
    List<CursoEntity> findAllByOrderByDataCriacaoDesc();
}