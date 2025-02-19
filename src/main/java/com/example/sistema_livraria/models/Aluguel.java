package com.example.sistema_livraria.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Aluguel", nullable = false)
    private int idAluguel;

    @Column(name = "Data", nullable = false)
    private LocalDateTime data;

    @Column(name = "Valor", nullable = false)
    private double valor;

    // Construtor padrão (obrigatório para JPA)
    public Aluguel() {}

    // Construtor com parâmetros
    public Aluguel(LocalDateTime data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    // Getters e Setters
    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}