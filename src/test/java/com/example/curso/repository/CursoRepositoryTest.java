package com.example.curso.repository;

import com.example.curso.entities.CursoEntity;
import com.example.curso.entities.UsuarioEntity;
import com.example.curso.mocks.CursoMock;
import com.example.curso.mocks.UsuarioMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    CursoEntity c1;
    CursoEntity c2;
    CursoEntity c3;

    @BeforeAll
    void setup(){
        c1 = cursoRepository.save(CursoMock.createCurso1());
        c2 = cursoRepository.save(CursoMock.createCurso2());
        c3 = cursoRepository.save(CursoMock.createCurso3());
    }

    @Test
    public void deveBuscarCursoPorNome() {
        List<CursoEntity> cursos = cursoRepository.findByNomeContaining("Java");
        assertEquals(1, cursos.size());
        assertTrue(cursos.contains(c1));
        assertFalse(cursos.contains(c2));
        assertFalse(cursos.contains(c2));
    }

    @Test
    public void deveBuscarCursoCategoria(){
        List<CursoEntity> cursos = cursoRepository.findByCategoriaContaining("Programação");
        assertEquals(2, cursos.size());
        assertTrue(cursos.contains(c1));
        assertFalse(cursos.contains(c2));
        assertTrue(cursos.contains(c3));
    }

    @Test
    public void deveBuscarCursoPorDataDeCriacao(){
        List<CursoEntity> cursos = cursoRepository.findAllByOrderByDataCriacaoAsc();
        assertEquals(3, cursos.size());
        assertEquals("Inglês avançado", cursos.get(0).getNome());
        assertEquals("Java para iniciantes", cursos.get(1).getNome());
        assertEquals("Introdução à inteligência artificial", cursos.get(2).getNome());
    }

    @Test
    public void deveBuscarCursoPorAvaliacao(){
        List<CursoEntity> cursos = cursoRepository.findAllByOrderByAvaliacaoDesc();
        assertEquals(3, cursos.size());
        assertEquals("Introdução à inteligência artificial", cursos.get(0).getNome());
        assertEquals("Inglês avançado", cursos.get(1).getNome());
        assertEquals("Java para iniciantes", cursos.get(2).getNome());
    }

    @Test
    public void deveBuscarCursosNaoConcluidosPorUsuario(){
        UsuarioEntity usuario = usuarioRepository.save(UsuarioMock.createUsuario(c1.getId()));
        List<CursoEntity> cursos = cursoRepository.findCursosNaoConcluidosPorUsuario(usuario.getId());
        assertEquals(2, cursos.size());
        assertEquals("Inglês avançado", cursos.get(0).getNome());
        assertEquals("Introdução à inteligência artificial", cursos.get(1).getNome());
    }

}
