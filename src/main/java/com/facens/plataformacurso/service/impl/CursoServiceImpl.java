package com.facens.plataformacurso.service.impl;
import com.facens.plataformacurso.dto.CursoDTO;
import com.facens.plataformacurso.entities.CursoEntity;
import com.facens.plataformacurso.mappers.CursoMapper;
import com.facens.plataformacurso.repository.CursoRepository;
import com.facens.plataformacurso.service.CursoService;
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


