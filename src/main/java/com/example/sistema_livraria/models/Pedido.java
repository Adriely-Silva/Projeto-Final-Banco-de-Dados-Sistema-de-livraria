package com.example.sistema_livraria.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "ID_Pedido", nullable = false)
    private int idPedido;

    @Column(name = "Data_Pedido", nullable = false)
    private LocalDateTime dataPedido;

    // Relacionamento Many-to-One com Funcionario
    @ManyToOne
    @JoinColumn(name = "ID_Func", nullable = false, foreignKey = @ForeignKey(name = "fk_pedido_funcionario", foreignKeyDefinition = "FOREIGN KEY (ID_Func) REFERENCES Funcionario(ID_Func) ON DELETE CASCADE"))
    private Funcionario funcionario;

    // Relacionamento Many-to-One com Aluguel (opcional)
    @ManyToOne
    @JoinColumn(name = "ID_Aluguel", foreignKey = @ForeignKey(name = "fk_pedido_aluguel", foreignKeyDefinition = "FOREIGN KEY (ID_Aluguel) REFERENCES Aluguel(ID_Aluguel) ON DELETE CASCADE"))
    private Aluguel aluguel;

    // Relacionamento Many-to-One com Cliente
    @ManyToOne
    @JoinColumn(name = "ID_Cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_pedido_cliente", foreignKeyDefinition = "FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente) ON DELETE CASCADE"))
    private Cliente cliente;

    // Relacionamento Many-to-One com Livro (opcional)
    @ManyToOne
    @JoinColumn(name = "ID_Livro", foreignKey = @ForeignKey(name = "fk_pedido_livro", foreignKeyDefinition = "FOREIGN KEY (ID_Livro) REFERENCES Livro(ID_Livro) ON DELETE CASCADE"))
    private Livro livro;

    // Construtor padrão (obrigatório para JPA)
    public Pedido() {}

    // Construtor com parâmetros
    public Pedido(LocalDateTime dataPedido, Funcionario funcionario, Cliente cliente, Aluguel aluguel, Livro livro) {
        this.dataPedido = dataPedido;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.aluguel = aluguel;
        this.livro = livro;
    }

    // Getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}