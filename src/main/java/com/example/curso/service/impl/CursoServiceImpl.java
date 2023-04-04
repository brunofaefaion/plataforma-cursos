package com.example.curso.service.impl;
import com.example.curso.dto.CursoDTO;
import com.example.curso.entities.CursoEntity;
import com.example.curso.mappers.CursoMapper;
import com.example.curso.repository.CursoRepository;
import com.example.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository repository;

    @Override
    public List<CursoDTO> findByNome(String nome) {
        List<CursoEntity> cursos = repository.findByNomeContaining(nome);
        return cursos.stream().map(CursoMapper::convertDTO).collect(Collectors.toList());
    }

    @Override
    public CursoDTO findCursoById(UUID id){
        Optional<CursoEntity> entityOptional = Optional.of(repository.getById(id));
        return entityOptional.map(CursoMapper::convertDTO).orElse(null);
    }

    @Override
    public List<CursoDTO> findByCategoria(String categoria) {
        List<CursoEntity> cursos = repository.findByCategoriaContaining(categoria);
        return cursos.stream().map(CursoMapper::convertDTO).collect(Collectors.toList());
    }

    @Override
    public List<CursoDTO> findAllByOrderByDataCriacaoAsc() {
        List<CursoEntity> cursos = repository.findAllByOrderByDataCriacaoAsc();
        return cursos.stream().map(CursoMapper::convertDTO).collect(Collectors.toList());
    }

    @Override
    public List<CursoDTO> findAllByOrderByAvaliacaoDesc() {
        List<CursoEntity> cursos = repository.findAllByOrderByAvaliacaoDesc();
        return cursos.stream().map(CursoMapper::convertDTO).collect(Collectors.toList());
    }

}


