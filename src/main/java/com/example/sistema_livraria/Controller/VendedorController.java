package com.example.sistema_livraria.Controller;

import com.example.sistema_livraria.Services.VendedorService;
import com.example.sistema_livraria.models.Vendedor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    // Endpoint para inserir um vendedor usando query nativa
    @PostMapping("/insert")
    public void insertVendedor(
            @RequestParam int idFunc,
            @RequestParam double metaVendas
    ) {
        vendedorService.insertVendedor(idFunc, metaVendas);
    }

    // Endpoint para deletar um vendedor por ID usando query nativa
    @Modifying
    @Transactional
    @DeleteMapping("/delete/{idFunc}")
    public void deleteVendedorById(@PathVariable int idFunc) {
        vendedorService.deleteVendedorById(idFunc);
    }

    @Autowired
    private VendedorService vendedorService;

    // Endpoint para salvar um vendedor
    @PostMapping
    public Vendedor saveVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.saveVendedor(vendedor);
    }

    // Endpoint para buscar todos os vendedores
    @GetMapping
    public List<Vendedor> findAllVendedores() {
        return vendedorService.findAllVendedores();
    }

    // Endpoint para buscar um vendedor por ID
    @GetMapping("/{idFunc}")
    public Optional<Vendedor> findVendedorById(@PathVariable int idFunc) {
        return vendedorService.findVendedorById(idFunc);
    }

    // Endpoint para buscar vendedores com meta de vendas maior que um valor
    @GetMapping("/meta/{metaVendas}")
    public List<Vendedor> findVendedoresByMetaVendasGreaterThan(@PathVariable double metaVendas) {
        return vendedorService.findVendedoresByMetaVendasGreaterThan(metaVendas);
    }
}