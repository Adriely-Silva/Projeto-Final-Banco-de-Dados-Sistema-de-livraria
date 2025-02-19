package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Prateleira_Livro")
public class PrateleiraLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Prat_Livro", nullable = false)
    private int idPratLivro;

    // Relacionamento Many-to-One com Prateleira
    @ManyToOne
    @JoinColumn(name = "ID_Prat", nullable = false, foreignKey = @ForeignKey(name = "fk_prateleira_livro_prateleira", foreignKeyDefinition = "FOREIGN KEY (ID_Prat) REFERENCES Prateleira(ID_Prat) ON DELETE CASCADE"))
    private Prateleira prateleira;

    // Relacionamento Many-to-One com Livro
    @ManyToOne
    @JoinColumn(name = "ID_Livro", nullable = false, foreignKey = @ForeignKey(name = "fk_prateleira_livro_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    @Column(name = "Quantia_Enfileirado")
    private int quantiaEnfileirado;

    // Construtor padrão (obrigatório para JPA)
    public PrateleiraLivro() {}

    // Construtor com parâmetros
    public PrateleiraLivro(Prateleira prateleira, Livro livro, int quantiaEnfileirado) {
        this.prateleira = prateleira;
        this.livro = livro;
        this.quantiaEnfileirado = quantiaEnfileirado;
    }

    // Getters e Setters
    public int getIdPratLivro() {
        return idPratLivro;
    }

    public void setIdPratLivro(int idPratLivro) {
        this.idPratLivro = idPratLivro;
    }

    public Prateleira getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(Prateleira prateleira) {
        this.prateleira = prateleira;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantiaEnfileirado() {
        return quantiaEnfileirado;
    }

    public void setQuantiaEnfileirado(int quantiaEnfileirado) {
        this.quantiaEnfileirado = quantiaEnfileirado;
    }
}
