package com.facens.plataformacurso.mappers;

import com.facens.plataformacurso.dto.UsuarioDTO;
import com.facens.plataformacurso.entities.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioDTO convertDTO(UsuarioEntity entity){
        return UsuarioDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .cursosConcluidos(entity.getCursosConcluidos())
                .cursosProgresso(entity.getCursosProgresso())
                .build();
    }

    public static UsuarioEntity convertEntity(UsuarioDTO dto){
        return UsuarioEntity.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cursosConcluidos(dto.getCursosConcluidos())
                .cursosProgresso(dto.getCursosProgresso())
                .build();
    }

}
