package com.example.curso.repository;

import com.example.curso.entities.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, UUID> {
    List<CursoEntity> findByNomeContaining(String nome);
    List<CursoEntity> findByCategoriaContaining(String categoria);
    List<CursoEntity> findAllByOrderByDataCriacaoAsc();
    List<CursoEntity> findAllByOrderByAvaliacaoDesc();

    @Query("SELECT c FROM CursoEntity c WHERE c.id NOT IN (SELECT cc FROM UsuarioEntity u JOIN u.cursosConcluidos cc WHERE u.id = :usuarioId)")
    List<CursoEntity> findCursosNaoConcluidosPorUsuario(@Param("usuarioId") UUID usuarioId);

}