package com.facens.plataformacurso.service;

import com.facens.plataformacurso.dto.UsuarioDTO;

import java.util.UUID;

public interface UsuarioService {
    UsuarioDTO postUsuario(UsuarioDTO usuario);
    UsuarioDTO getUsuarioPorId(UUID id);
    UsuarioDTO concluiCursoPorId(UUID idUsuario, UUID idCurso);
    UsuarioDTO adicionaCursoEmProgresso(UUID idUsuario, UUID idCurso);
}
