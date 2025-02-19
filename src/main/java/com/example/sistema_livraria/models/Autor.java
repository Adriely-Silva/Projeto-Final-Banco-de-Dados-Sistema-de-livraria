package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Autor", nullable = false)
    private int idAutor;

    @Column(name = "Nome_Autor", length = 50)
    private String nomeAutor;

    // Construtor padrão (obrigatório para JPA)
    public Autor() {}

    // Construtor com parâmetros
    public Autor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    // Getters e Setters
    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
