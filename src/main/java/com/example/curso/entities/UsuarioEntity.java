
package com.example.curso.entities;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @Column(name = "assinatura")
    private Boolean assinatura;

    @ElementCollection
    @CollectionTable(name = "usuario_curso_concluido",
            joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "curso_concluido_id")
    private Set<Long> cursosConcluidos;

    @ElementCollection
    @CollectionTable(name = "usuario_curso_progresso",
            joinColumns = @JoinColumn(name = "usuario_id"))
    @MapKeyColumn(name = "curso_progresso_id")
    @Column(name = "porcentagem")
    private Map<Long, Double> cursosProgresso;

    //getters e setters
}
