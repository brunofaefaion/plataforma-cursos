package com.facens.plataformacurso.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class CursoDTO {
    private UUID id;
    private String nome;
    private String categoria;
    private Double avaliacao;
    private LocalDate dataCriacao;
}
