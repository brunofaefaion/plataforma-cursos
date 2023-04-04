package com.example.curso.mocks;

import com.example.curso.entities.UsuarioEntity;

import java.util.Collections;
import java.util.UUID;

public class UsuarioMock {

    public static UsuarioEntity createUsuario(UUID idCurso){
        return UsuarioEntity.builder()
                .nome("João Pedro")
                .email("joaopedro@outlook.com")
                .cursosConcluidos(Collections.singleton(idCurso))
                .build();
    }

}
