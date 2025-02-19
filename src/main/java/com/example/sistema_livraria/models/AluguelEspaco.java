package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Aluguel_Espaço")
public class AluguelEspaco {

    @Id
    @Column(name = "ID_Aluguel", nullable = false)
    private int idAluguel;

    @Column(name = "Tempo_Aluguel", nullable = false)
    private String tempoAluguel;

    // Relacionamento One-to-One com Aluguel
    @OneToOne
    @MapsId // Usa o mesmo ID da tabela Aluguel
    @JoinColumn(name = "ID_Aluguel", nullable = false, foreignKey = @ForeignKey(name = "fk_aluguel_espaco_aluguel", foreignKeyDefinition = "FOREIGN KEY (ID_Aluguel) REFERENCES Aluguel(ID_Aluguel) ON DELETE CASCADE"))
    private Aluguel aluguel;

    // Construtor padrão (obrigatório para JPA)
    public AluguelEspaco() {}

    // Construtor com parâmetros
    public AluguelEspaco(String tempoAluguel, Aluguel aluguel) {
        this.tempoAluguel = tempoAluguel;
        this.aluguel = aluguel;
    }

    // Getters e Setters
    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public String getTempoAluguel() {
        return tempoAluguel;
    }

    public void setTempoAluguel(String tempoAluguel) {
        this.tempoAluguel = tempoAluguel;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}
