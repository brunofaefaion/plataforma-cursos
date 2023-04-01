package com.example.curso.service;

import com.example.curso.dto.CursoDTO;
import com.example.curso.entities.CursoEntity;
import com.example.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List getCursosRecentes() {
        return null;
    }

    public List getByNome(String nome) {
        return null;
    }

    public List<CursoDTO> findCursosByNome(String nome) {
        List<CursoEntity> cursos = cursoRepository.findByNome(nome);
    }

}


