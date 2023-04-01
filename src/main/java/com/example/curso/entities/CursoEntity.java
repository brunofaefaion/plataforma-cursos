package com.example.curso.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

//

@Entity
@Table(name = "curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private Double avaliacao;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    public CursoEntity(String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }
}
