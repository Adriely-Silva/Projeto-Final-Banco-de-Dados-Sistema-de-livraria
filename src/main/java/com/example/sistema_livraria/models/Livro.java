package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Livro", nullable = false)
    private int idLivro;

    @Column(name = "Titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "Preco", nullable = false)
    private double preco;

    @Column(name = "ISBN")
    private long isbn;

    // Relacionamento Many-to-One com Editora
    @ManyToOne
    @JoinColumn(name = "ID_Editora", nullable = false, foreignKey = @ForeignKey(name = "fk_livro_editora", foreignKeyDefinition = "FOREIGN KEY (ID_Editora) REFERENCES Editora(ID_Editora) ON DELETE CASCADE"))
    private Editora editora;

    // Construtor padrão (obrigatório para JPA)
    public Livro() {}

    // Construtor com parâmetros
    public Livro(String titulo, double preco, long isbn, Editora editora) {
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.editora = editora;
    }

    // Getters e Setters
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}