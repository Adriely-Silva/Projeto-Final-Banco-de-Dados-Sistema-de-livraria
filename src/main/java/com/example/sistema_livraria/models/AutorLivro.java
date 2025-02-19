package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Autor_Livro")
public class AutorLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Autor_Livro", nullable = false)
    private int idAutorLivro;

    // Relacionamento Many-to-One com Autor
    @ManyToOne
    @JoinColumn(name = "ID_Autor", nullable = false, foreignKey = @ForeignKey(name = "fk_autor_livro_autor", foreignKeyDefinition = "FOREIGN KEY (ID_Autor) REFERENCES Autor(ID_Autor) ON DELETE CASCADE"))
    private Autor autor;

    // Relacionamento Many-to-One com Livro
    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false, foreignKey = @ForeignKey(name = "fk_autor_livro_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    // Construtor padrão (obrigatório para JPA)
    public AutorLivro() {}

    // Construtor com parâmetros
    public AutorLivro(Autor autor, Livro livro) {
        this.autor = autor;
        this.livro = livro;
    }

    // Getters e Setters
    public int getIdAutorLivro() {
        return idAutorLivro;
    }

    public void setIdAutorLivro(int idAutorLivro) {
        this.idAutorLivro = idAutorLivro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}