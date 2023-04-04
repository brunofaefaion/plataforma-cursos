package com.example.curso.mocks;

import com.example.curso.entities.CursoEntity;

import java.time.LocalDate;
import java.util.List;

public class CursoMock {

    public static CursoEntity createCurso1(){
        return CursoEntity.builder()
                .nome("Java para iniciantes")
                .categoria("Programação")
                .avaliacao(4.5)
                .dataCriacao(LocalDate.of(2022, 3, 1))
                .build();
    }

    public static CursoEntity createCurso2(){
        return CursoEntity.builder()
                .nome("Inglês avançado")
                .categoria("Idiomas")
                .avaliacao(4.7)
                .dataCriacao(LocalDate.of(2019, 5, 12))
                .build();
    }

    public static CursoEntity createCurso3(){
        return CursoEntity.builder()
                .nome("Introdução à inteligência artificial")
                .categoria("Programação")
                .avaliacao(4.8)
                .dataCriacao(LocalDate.of(2022, 11, 21))
                .build();
    }

    public static List<CursoEntity> getListaCursos(){
        return List.of(createCurso1(), createCurso2(), createCurso3());
    }

}
