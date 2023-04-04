package com.example.curso.service.impl;

import com.example.curso.dto.CursoDTO;
import com.example.curso.dto.UsuarioDTO;
import com.example.curso.entities.UsuarioEntity;
import com.example.curso.mappers.UsuarioMapper;
import com.example.curso.repository.UsuarioRepository;
import com.example.curso.service.CursoService;
import com.example.curso.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioDTO postUsuario(UsuarioDTO usuario) {
        UsuarioEntity entity = UsuarioMapper.convertEntity(usuario);
        return UsuarioMapper.convertDTO(repository.save(entity));
    }

    @Override
    public UsuarioDTO getUsuarioPorId(UUID id){
        Optional<UsuarioEntity> entityOptional = Optional.of(repository.getById(id));
        return entityOptional.map(UsuarioMapper::convertDTO).orElse(null);
    }

    @Override
    public UsuarioDTO concluiCursoPorId(UUID idUsuario, UUID idCurso){
        UsuarioDTO usuarioDTO = getUsuarioPorId(idUsuario);
        CursoDTO cursoDTO = cursoService.findCursoById(idCurso);
        usuarioDTO.addCursosConcluidos(cursoDTO.getId());
        return postUsuario(usuarioDTO);
    }

    @Override
    public UsuarioDTO adicionaCursoEmProgresso(UUID idUsuario, UUID idCurso){
        UsuarioDTO usuarioDTO = getUsuarioPorId(idUsuario);
        CursoDTO cursoDTO = cursoService.findCursoById(idCurso);
        usuarioDTO.addCursosProgresso(cursoDTO.getId(), 0.0);
        return postUsuario(usuarioDTO);
    }

}
