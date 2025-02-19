package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Editora", nullable = false)
    private int idEditora;

    @Column(name = "Nome_Editora", length = 50)
    private String nomeEditora;

    // Construtor padrão (obrigatório para JPA)
    public Editora() {}

    // Construtor com parâmetros
    public Editora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    // Getters e Setters
    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
}