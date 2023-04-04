package com.facens.plataformacurso.mocks;

import com.facens.plataformacurso.entities.UsuarioEntity;

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
