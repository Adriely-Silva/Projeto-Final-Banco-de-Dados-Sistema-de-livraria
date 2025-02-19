package com.example.sistema_livraria.Services;

import com.example.sistema_livraria.models.Livro;
import com.example.sistema_livraria.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EstoqueService estoqueService;

    // Método para inserir um livro usando query nativa
    public void insertLivro(String titulo, double preco, long isbn, int idEditora) {
        livroRepository.insertLivro(titulo, preco, isbn, idEditora);
    }

    // Método para deletar um livro por ID usando query nativa
    public void deleteLivroById(int idLivro) {
        livroRepository.deleteLivroById(idLivro);
    }

    // Método para alterar um livro por ID usando query nativa
    public void updateLivroById(int idLivro, String titulo, double preco, long isbn, int idEditora) {
        livroRepository.updateLivroById(idLivro, titulo, preco, isbn, idEditora);
    }

    // Método para salvar um livro
    public Livro saveLivro(Livro livro) {
        Livro savedLivro = livroRepository.save(livro);
        estoqueService.createEstoqueForLivro(savedLivro.getIdLivro()); // Criar estoque ao adicionar livro
        return savedLivro;
    }

    // Método para inserir vários livros de uma vez
    public void insertManyLivros(List<Livro> livros) {
        livroRepository.saveAll(livros);
    }

    // Método para deletar um livro
    public void deleteLivro(int idLivro) {
        livroRepository.deleteById(idLivro);
        estoqueService.removeEstoqueForLivro(idLivro); // Remover estoque ao excluir livro
    }
    // Método para buscar todos os livros
    public List<Livro> findAllLivros() {
        return livroRepository.findAllLivros();
    }

    // Método para buscar um livro por ID
    public Optional<Livro> findLivroById(int idLivro) {
        return livroRepository.findLivroById(idLivro);
    }

    // Método para buscar livros por título
    public List<Livro> findLivrosByTitulo(String titulo) {
        return livroRepository.findLivrosByTitulo(titulo);
    }

    // Método para buscar livros por editora
    public List<Livro> findLivrosByEditora(int idEditora) {
        return livroRepository.findLivrosByEditora(idEditora);
    }

    // Método para contar livros por editora com preço médio acima de 40.00
    public List<Object[]> contarLivrosPorEditora() {
        return livroRepository.contarLivrosPorEditora();
    }

    // Método para buscar livros ordenados por título ou preço
    public List<Livro> getAllLivrosSorted(String orderBy, String direction) {
        if (!orderBy.equals("titulo") && !orderBy.equals("preco")) {
            throw new IllegalArgumentException("O campo de ordenação deve ser 'titulo' ou 'preco'.");
        }
        if (!direction.equalsIgnoreCase("ASC") && !direction.equalsIgnoreCase("DESC")) {
            throw new IllegalArgumentException("A direção deve ser 'ASC' ou 'DESC'.");
        }
        return livroRepository.findAllSorted(orderBy, direction);
    }
    public List<Livro> getLivrosPrecoMaiorQueTodosDaEditora(int editoraId) {
        return livroRepository.findLivrosComPrecoMaiorQueTodosDaEditora(editoraId);
    }

    public Integer getQuantidadeEstoque(int idLivro) {
        return livroRepository.findQuantidadeEstoque(idLivro);
    }


}