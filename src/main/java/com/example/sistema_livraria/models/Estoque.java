package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Estoque")
public class Estoque {

    @Id
    @Column(name = "ID_Livro", nullable = false)
    private int idLivro;

    @Column(name = "Quantidade", nullable = false)
    private int quantidade;

    // Relacionamento Many-to-One com Livro
    @OneToOne
    @MapsId // Usa o mesmo ID da tabela Livro
    @JoinColumn(name = "ID_Livro", nullable = false, foreignKey = @ForeignKey(name = "fk_estoque_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    // Construtor padrão (obrigatório para JPA)
    public Estoque() {}

    // Construtor com parâmetros
    public Estoque(int quantidade, Livro livro) {
        this.quantidade = quantidade;
        this.livro = livro;
    }

    // Getters e Setters
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}