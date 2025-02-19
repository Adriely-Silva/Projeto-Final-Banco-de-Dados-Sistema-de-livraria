package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Cliente", nullable = false)
    private int idCliente;

    @Column(name = "Nome_Cliente", nullable = false, length = 50)
    private String nomeCliente;

    @Column(name = "Fidelidade", length = 50)
    private String fidelidade;

    @Column(name = "CPF_Cliente", nullable = false)
    private long cpfCliente;

    // Construtor padrão (obrigatório para JPA)
    public Cliente() {}

    // Construtor com parâmetros
    public Cliente(String nomeCliente, String fidelidade, long cpfCliente) {
        this.nomeCliente = nomeCliente;
        this.fidelidade = fidelidade;
        this.cpfCliente = cpfCliente;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFidelidade() {
        return fidelidade;
    }

    public void setFidelidade(String fidelidade) {
        this.fidelidade = fidelidade;
    }

    public long getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(long cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}