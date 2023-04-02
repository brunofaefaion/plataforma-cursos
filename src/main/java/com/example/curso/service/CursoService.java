package com.example.curso.service;

import com.example.curso.dto.CursoDTO;

import java.util.List;
import java.util.UUID;

public interface CursoService {

    List<CursoDTO> findByNome(String nome);
    CursoDTO findCursoById(UUID id);
    List<CursoDTO> findByCategoria(String categoria);
    List<CursoDTO> findAllByOrderByDataCriacaoAsc();
    List<CursoDTO> findAllByOrderByAvaliacaoDesc();

}


