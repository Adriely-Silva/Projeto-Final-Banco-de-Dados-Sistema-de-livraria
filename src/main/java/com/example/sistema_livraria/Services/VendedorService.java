package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Vendedor;
import com.example.sistema_livraria.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    // Método para inserir um vendedor usando query nativa
    public void insertVendedor(int idFunc, double metaVendas) {
        vendedorRepository.insertVendedor(idFunc, metaVendas);
    }

    // Método para deletar um vendedor por ID usando query nativa
    public void deleteVendedorById(int idFunc) {
        vendedorRepository.deleteVendedorById(idFunc);
    }

    // Método para salvar um vendedor
    public Vendedor saveVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    // Método para buscar todos os vendedores
    public List<Vendedor> findAllVendedores() {
        return vendedorRepository.findAllVendedores();
    }

    // Método para buscar um vendedor por ID
    public Optional<Vendedor> findVendedorById(int idFunc) {
        return vendedorRepository.findVendedorById(idFunc);
    }

    // Método para buscar vendedores com meta de vendas maior que um valor
    public List<Vendedor> findVendedoresByMetaVendasGreaterThan(double metaVendas) {
        return vendedorRepository.findVendedoresByMetaVendasGreaterThan(metaVendas);
    }
}