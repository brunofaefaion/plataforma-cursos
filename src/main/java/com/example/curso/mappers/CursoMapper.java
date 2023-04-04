package com.example.curso.mappers;

import com.example.curso.dto.CursoDTO;
import com.example.curso.entities.CursoEntity;

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
