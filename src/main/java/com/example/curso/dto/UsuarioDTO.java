package com.example.curso.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class UsuarioDTO {
    private UUID id;
    private String nome;
    private String email;
    private Set<UUID> cursosConcluidos;
    private Map<UUID, Double> cursosProgresso;

    public void addCursosConcluidos(UUID id){
        cursosConcluidos.add(id);
    }

    public void addCursosProgresso(UUID idCurso, Double porcentagem){
        cursosProgresso.put(idCurso, porcentagem);
    }

}
