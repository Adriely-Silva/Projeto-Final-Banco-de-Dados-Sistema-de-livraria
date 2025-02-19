package com.example.sistema_livraria.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Edicao_Livro")
public class EdicaoLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Edicao_Livro", nullable = false)
    private int idEdicaoLivro;

    // Relacionamento Many-to-One com Edicao
    @ManyToOne
    @JoinColumn(name = "ID_Edicao", nullable = false, foreignKey = @ForeignKey(name = "fk_edicao_livro_edicao", foreignKeyDefinition = "FOREIGN KEY (ID_Edicao) REFERENCES Edicao(ID_Edicao) ON DELETE CASCADE"))
    private Edicao edicao;

    // Relacionamento Many-to-One com Livro
    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false, foreignKey = @ForeignKey(name = "fk_edicao_livro_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    // Construtor padrão (obrigatório para JPA)
    public EdicaoLivro() {}

    // Construtor com parâmetros
    public EdicaoLivro(Edicao edicao, Livro livro) {
        this.edicao = edicao;
        this.livro = livro;
    }

    // Getters e Setters
    public int getIdEdicaoLivro() {
        return idEdicaoLivro;
    }

    public void setIdEdicaoLivro(int idEdicaoLivro) {
        this.idEdicaoLivro = idEdicaoLivro;
    }

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
