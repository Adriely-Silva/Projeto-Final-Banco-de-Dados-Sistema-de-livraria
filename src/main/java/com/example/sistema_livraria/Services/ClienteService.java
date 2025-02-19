package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Cliente;
import com.example.sistema_livraria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para inserir um cliente usando query nativa
    public void insertCliente(String nomeCliente, String fidelidade, long cpfCliente) {
        clienteRepository.insertCliente(nomeCliente, fidelidade, cpfCliente);
    }

    // Método para deletar um cliente por ID usando query nativa
    public void deleteClienteById(int idCliente) {
        clienteRepository.deleteClienteById(idCliente);
    }

    // Método para salvar um cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para buscar todos os clientes
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAllClientes();
    }

    // Método para buscar um cliente por ID
    public Optional<Cliente> findClienteById(int idCliente) {
        return clienteRepository.findClienteById(idCliente);
    }

    // Método para buscar clientes por nome
    public List<Cliente> findClientesByNome(String nomeCliente) {
        return clienteRepository.findClientesByNome(nomeCliente);
    }

    // Método para buscar um cliente por CPF
    public Optional<Cliente> findClienteByCpf(long cpfCliente) {
        return clienteRepository.findClienteByCpf(cpfCliente);
    }
}