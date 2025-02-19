package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros_alugados")
public class LivrosAlugados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Livros_Alugados", nullable = false)
    private int idLivrosAlugados;

    // Relacionamento Many-to-One com Aluguel_Livro
    @ManyToOne
    @JoinColumn(name = "ID_Aluguel", nullable = false, foreignKey = @ForeignKey(name = "fk_livros_alugados_aluguel_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Aluguel) REFERENCES Aluguel_Livro(ID_Aluguel) ON DELETE CASCADE"))
    private AluguelLivro aluguelLivro;

    // Relacionamento Many-to-One com Livro
    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false, foreignKey = @ForeignKey(name = "fk_livros_alugados_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    // Construtor padrão (obrigatório para JPA)
    public LivrosAlugados() {}

    // Construtor com parâmetros
    public LivrosAlugados(AluguelLivro aluguelLivro, Livro livro) {
        this.aluguelLivro = aluguelLivro;
        this.livro = livro;
    }

    // Getters e Setters
    public int getIdLivrosAlugados() {
        return idLivrosAlugados;
    }

    public void setIdLivrosAlugados(int idLivrosAlugados) {
        this.idLivrosAlugados = idLivrosAlugados;
    }

    public AluguelLivro getAluguelLivro() {
        return aluguelLivro;
    }

    public void setAluguelLivro(AluguelLivro aluguelLivro) {
        this.aluguelLivro = aluguelLivro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}