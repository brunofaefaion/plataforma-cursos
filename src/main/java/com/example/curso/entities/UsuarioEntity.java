
package com.example.curso.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String email;

    @ElementCollection
    @CollectionTable(name = "usuario_curso_concluido",
            joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "curso_concluido_id")
    private Set<UUID> cursosConcluidos;

    @ElementCollection
    @CollectionTable(name = "usuario_curso_progresso",
            joinColumns = @JoinColumn(name = "usuario_id"))
    @MapKeyColumn(name = "curso_progresso_id")
    @Column(name = "porcentagem")
    private Map<UUID, Double> cursosProgresso;
}
