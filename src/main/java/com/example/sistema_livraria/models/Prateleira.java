package com.example.sistema_livraria.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Prateleira")
public class Prateleira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Prat", nullable = false)
    private int idPrat;

    @Column(name = "Num_Corredor", nullable = false)
    private int numCorredor;

    // Construtor padrão (obrigatório para JPA)
    public Prateleira() {}

    // Construtor com parâmetros
    public Prateleira(int numCorredor) {
        this.numCorredor = numCorredor;
    }

    // Getters e Setters
    public int getIdPrat() {
        return idPrat;
    }

    public void setIdPrat(int idPrat) {
        this.idPrat = idPrat;
    }

    public int getNumCorredor() {
        return numCorredor;
    }

    public void setNumCorredor(int numCorredor) {
        this.numCorredor = numCorredor;
    }
}
