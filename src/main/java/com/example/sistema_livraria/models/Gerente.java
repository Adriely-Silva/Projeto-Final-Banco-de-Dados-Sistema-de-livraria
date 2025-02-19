package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Gerente")
public class Gerente {

    @Id
    @Column(name = "ID_Func", nullable = false)
    private int idFunc;

    @Column(name = "Tipo_Func", nullable = false)
    private String tipoFunc;

    // Relacionamento com a tabela Funcionario
    @OneToOne
    @MapsId // Usa o mesmo ID da tabela Funcionario
    @JoinColumn(name = "ID_Func", foreignKey = @ForeignKey(name = "fk_gerente_funcionario", foreignKeyDefinition = "FOREIGN KEY (ID_Func) REFERENCES Funcionario(ID_Func) ON DELETE CASCADE"))
    private Funcionario funcionario;

    // Construtor padrão (obrigatório para JPA)
    public Gerente() {}

    // Construtor com parâmetros
    public Gerente(int idFunc, String tipoFunc, Funcionario funcionario) {
        this.idFunc = idFunc;
        this.tipoFunc = tipoFunc;
        this.funcionario = funcionario;
    }

    // Getters e Setters
    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(String tipoFunc) {
        this.tipoFunc = tipoFunc;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}