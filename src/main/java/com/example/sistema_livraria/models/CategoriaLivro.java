package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Categoria_Livro")
public class CategoriaLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Categoria_Livro", nullable = false)
    private int idCategoriaLivro;

    // Relacionamento Many-to-One com Categoria
    @ManyToOne
    @JoinColumn(name = "ID_Categoria", nullable = false, foreignKey = @ForeignKey(name = "fk_categoria_livro_categoria", foreignKeyDefinition = "FOREIGN KEY (ID_Categoria) REFERENCES Categoria(ID_Categoria) ON DELETE CASCADE"))
    private Categoria categoria;

    // Relacionamento Many-to-One com Livro
    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false, foreignKey = @ForeignKey(name = "fk_categoria_livro_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    // Construtor padrão (obrigatório para JPA)
    public CategoriaLivro() {}

    // Construtor com parâmetros
    public CategoriaLivro(Categoria categoria, Livro livro) {
        this.categoria = categoria;
        this.livro = livro;
    }

    // Getters e Setters
    public int getIdCategoriaLivro() {
        return idCategoriaLivro;
    }

    public void setIdCategoriaLivro(int idCategoriaLivro) {
        this.idCategoriaLivro = idCategoriaLivro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
