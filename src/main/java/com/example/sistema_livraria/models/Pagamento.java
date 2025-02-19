package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "Boleto")
    private double boleto;

    @Column(name = "Crédito")
    private double credito;

    @Column(name = "Débito")
    private double debito;

    @Column(name = "Pix")
    private double pix;

    // Relacionamento Many-to-One com Pedido
    @ManyToOne
    @JoinColumn(name = "id_Pedido", nullable = false, foreignKey = @ForeignKey(name = "fk_pagamento_pedido", foreignKeyDefinition = "FOREIGN KEY (id_Pedido) REFERENCES Pedido(ID_Pedido) ON DELETE CASCADE"))
    private Pedido pedido;

    // Construtor padrão (obrigatório para JPA)
    public Pagamento() {}

    // Construtor com parâmetros
    public Pagamento(double boleto, double credito, double debito, double pix, Pedido pedido) {
        this.boleto = boleto;
        this.credito = credito;
        this.debito = debito;
        this.pix = pix;
        this.pedido = pedido;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBoleto() {
        return boleto;
    }

    public void setBoleto(double boleto) {
        this.boleto = boleto;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getPix() {
        return pix;
    }

    public void setPix(double pix) {
        this.pix = pix;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
