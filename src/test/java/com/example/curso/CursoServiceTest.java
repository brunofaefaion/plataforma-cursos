package com.example.curso;

import com.example.curso.entities.CursoEntity;
import com.example.curso.repository.CursoRepository;
import com.example.curso.service.CursoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    private CursoService cursoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        cursoService = new CursoService();
    }

    @Test
    @DisplayName("Dado que sou um usuário, quando procuro por cursos por nome, então os visualizo")
    void testBuscaCursosPorNome() {
        String nomeCurso = "Java para iniciantes";
        List<CursoEntity> cursos = Arrays.asList(
                new CursoEntity("Java para iniciantes"),
                new CursoEntity("Spring Boot para iniciantes"),
                new CursoEntity("Java para desenvolvedores avançados")
        );
        when(cursoRepository.findByNome(nomeCurso)).thenReturn(cursos);

        List<String> nomesCursosEncontrados = cursoService.findCursosByNome(nomeCurso);

        assertEquals(1, nomesCursosEncontrados.size());
        assertTrue(nomesCursosEncontrados.contains("Java para iniciantes"));
    }

    // Passo 2
//    @Test
//    @DisplayName("Dado que sou um usuário, quando procuro por cursos recentes, então os visualizo em ordem de criação")
//    void testBuscaCursosRecentes() {
//        List<Curso> cursos = Arrays.asList(
//                new Curso("Java para iniciantes"),
//                new Curso("Spring Boot para iniciantes"),
//                new Curso("Java para desenvolvedores avançados")
//        );
//        when(cursoRepository.findAllByOrderByDataCriacaoDesc()).thenReturn(cursos);
//
//        List<String> nomesCursosEncontrados = cursoService.buscarCursosRecentes()
//                .stream()
//                .map(Curso::getNome)
//                .collect(Collectors.toList());
//
//        assertEquals(3, nomesCursosEncontrados.size());
//        assertEquals("Java para iniciantes", nomesCursosEncontrados.get(0));
//        assertEquals("Spring Boot para iniciantes", nomesCursosEncontrados.get(1));
//        assertEquals("Java para desenvolvedores avançados", nomesCursosEncontrados.get(2));
//    }
}
