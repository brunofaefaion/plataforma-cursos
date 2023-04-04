package com.facens.plataformacurso.mappers;

import com.facens.plataformacurso.dto.CursoDTO;
import com.facens.plataformacurso.entities.CursoEntity;

public class CursoMapper {
    public static CursoDTO convertDTO(CursoEntity entity){
        return CursoDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .categoria(entity.getCategoria())
                .avaliacao(entity.getAvaliacao())
                .dataCriacao(entity.getDataCriacao())
                .build();
    }

    public static CursoEntity convertEntity(CursoDTO dto){
        return CursoEntity.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .avaliacao(dto.getAvaliacao())
                .dataCriacao(dto.getDataCriacao())
                .build();
    }

}
