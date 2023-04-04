package com.facens.plataformacurso.service.impl;

import com.facens.plataformacurso.dto.CursoDTO;
import com.facens.plataformacurso.dto.UsuarioDTO;
import com.facens.plataformacurso.entities.UsuarioEntity;
import com.facens.plataformacurso.mappers.UsuarioMapper;
import com.facens.plataformacurso.repository.UsuarioRepository;
import com.facens.plataformacurso.service.CursoService;
import com.facens.plataformacurso.service.UsuarioService;
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
