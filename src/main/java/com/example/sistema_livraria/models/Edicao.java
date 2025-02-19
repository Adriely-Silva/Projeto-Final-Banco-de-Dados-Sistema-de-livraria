package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Edicao")
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Edicao", nullable = false)
    private int idEdicao;

    @Column(name = "Num_Edicao", nullable = false)
    private int numEdicao;

    // Construtor padrão (obrigatório para JPA)
    public Edicao() {}

    // Construtor com parâmetros
    public Edicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }

    // Getters e Setters
    public int getIdEdicao() {
        return idEdicao;
    }

    public void setIdEdicao(int idEdicao) {
        this.idEdicao = idEdicao;
    }

    public int getNumEdicao() {
        return numEdicao;
    }

    public void setNumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }
}