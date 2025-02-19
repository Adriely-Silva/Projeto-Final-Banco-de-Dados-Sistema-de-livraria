package com.example.sistema_livraria.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Aluguel_Livro")
public class AluguelLivro {

    @Id
    @Column(name = "ID_Aluguel", nullable = false)
    private int idAluguel;

    @Column(name = "Data_Devolução", nullable = false)
    private LocalDateTime dataDevolucao;

    @Column(name = "Multa_Atraso")
    private double multaAtraso;

    // Relacionamento One-to-One com Aluguel
    @OneToOne
    @MapsId // Usa o mesmo ID da tabela Aluguel
    @JoinColumn(name = "ID_Aluguel", nullable = false, foreignKey = @ForeignKey(name = "fk_aluguel_livro_aluguel", foreignKeyDefinition = "FOREIGN KEY (ID_Aluguel) REFERENCES Aluguel(ID_Aluguel) ON DELETE CASCADE"))
    private Aluguel aluguel;

    // Construtor padrão (obrigatório para JPA)
    public AluguelLivro() {}

    // Construtor com parâmetros
    public AluguelLivro(LocalDateTime dataDevolucao, double multaAtraso, Aluguel aluguel) {
        this.dataDevolucao = dataDevolucao;
        this.multaAtraso = multaAtraso;
        this.aluguel = aluguel;
    }

    // Getters e Setters
    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}
