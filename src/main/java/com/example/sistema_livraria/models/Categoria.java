package com.example.sistema_livraria.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Categoria", nullable = false)
    private int idCategoria;

    @Column(name = "Nome_Categoria", nullable = false, length = 50)
    private String nomeCategoria;

    // Construtor padrão (obrigatório para JPA)
    public Categoria() {}

    // Construtor com parâmetros
    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    // Getters e Setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
