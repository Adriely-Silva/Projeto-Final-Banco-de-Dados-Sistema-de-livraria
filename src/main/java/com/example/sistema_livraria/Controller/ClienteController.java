package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.ClienteService;
import com.example.sistema_livraria.models.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Endpoint para inserir um cliente usando query nativa
    @PostMapping("/insert")
    public void insertCliente(
            @RequestParam String nomeCliente,
            @RequestParam String fidelidade,
            @RequestParam long cpfCliente
    ) {
        clienteService.insertCliente(nomeCliente, fidelidade, cpfCliente);
    }

    // Endpoint para deletar um cliente por ID usando query nativa
    @Modifying
    @Transactional
    @DeleteMapping("/delete/{idCliente}")
    public void deleteClienteById(@PathVariable int idCliente) {
        clienteService.deleteClienteById(idCliente);
    }

    // Endpoint para salvar um cliente
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    // Endpoint para buscar todos os clientes
    @GetMapping
    public List<Cliente> findAllClientes() {
        return clienteService.findAllClientes();
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{idCliente}")
    public Optional<Cliente> findClienteById(@PathVariable int idCliente) {
        return clienteService.findClienteById(idCliente);
    }

    // Endpoint para buscar clientes por nome
    @GetMapping("/nome/{nomeCliente}")
    public List<Cliente> findClientesByNome(@PathVariable String nomeCliente) {
        return clienteService.findClientesByNome(nomeCliente);
    }

    // Endpoint para buscar um cliente por CPF
    @GetMapping("/cpf/{cpfCliente}")
    public Optional<Cliente> findClienteByCpf(@PathVariable long cpfCliente) {
        return clienteService.findClienteByCpf(cpfCliente);
    }
}