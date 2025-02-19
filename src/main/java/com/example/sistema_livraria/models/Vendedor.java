package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    @Column(name = "ID_Func", nullable = false)
    private int idFunc;

    @Column(name = "Meta_Vendas", nullable = false)
    private double metaVendas;

    // Relacionamento com a tabela Funcionario
    @OneToOne
    @MapsId // Usa o mesmo ID da tabela Funcionario
    @JoinColumn(name = "ID_Func", foreignKey = @ForeignKey(name = "fk_vendedor_funcionario", foreignKeyDefinition = "FOREIGN KEY (ID_Func) REFERENCES Funcionario(ID_Func) ON DELETE CASCADE"))
    private Funcionario funcionario;

    // Construtor padrão (obrigatório para JPA)
    public Vendedor() {}

    // Construtor com parâmetros
    public Vendedor(int idFunc, double metaVendas, Funcionario funcionario) {
        this.idFunc = idFunc;
        this.metaVendas = metaVendas;
        this.funcionario = funcionario;
    }

    // Getters e Setters
    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}