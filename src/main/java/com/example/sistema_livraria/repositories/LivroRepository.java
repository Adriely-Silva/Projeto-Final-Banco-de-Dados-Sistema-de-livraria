package com.example.sistema_livraria.repositories;

import com.example.sistema_livraria.models.Livro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    // Query nativa para INSERT
    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO Livro (Titulo, Preco, ISBN, ID_Editora) VALUES (:titulo, :preco, :isbn, :idEditora)",
            nativeQuery = true
    )
    void insertLivro(String titulo, double preco, long isbn, int idEditora);

    // Query nativa para DELETE
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM Livro WHERE ID_Livro = :idLivro",
            nativeQuery = true
    )
    void deleteLivroById(int idLivro);

    // Query nativa para UPDATE
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE Livro SET Titulo = :titulo, Preco = :preco, ISBN = :isbn, ID_Editora = :idEditora WHERE ID_Livro = :idLivro",
            nativeQuery = true
    )
    void updateLivroById(int idLivro, String titulo, double preco, long isbn, int idEditora);

    // Consulta personalizada para buscar todos os livros
    @Query("SELECT l FROM Livro l")
    List<Livro> findAllLivros();

    // Consulta personalizada para buscar um livro por ID
    @Query("SELECT l FROM Livro l WHERE l.idLivro = :idLivro")
    Optional<Livro> findLivroById(int idLivro);

    // Consulta personalizada para buscar livros por título
    @Query("SELECT l FROM Livro l WHERE l.titulo LIKE %:titulo%")
    List<Livro> findLivrosByTitulo(String titulo);

    // Consulta personalizada para buscar livros por editora
    @Query("SELECT l FROM Livro l WHERE l.editora.idEditora = :idEditora")
    List<Livro> findLivrosByEditora(int idEditora);

    @Query("SELECT e.nomeEditora, COUNT(l), AVG(l.preco) " +
            "FROM Livro l " +
            "JOIN l.editora e " +
            "GROUP BY e.nomeEditora " +
            "HAVING AVG(l.preco) > 40.00")
    List<Object[]> contarLivrosPorEditora();

    // Consulta ordenada parametrizada que permite escolher o campo e a direção da ordenação
    @Query(value = "SELECT * FROM Livro ORDER BY " +
            "CASE WHEN :orderBy = 'titulo' AND :direction = 'ASC' THEN titulo END ASC, " +
            "CASE WHEN :orderBy = 'titulo' AND :direction = 'DESC' THEN titulo END DESC, " +
            "CASE WHEN :orderBy = 'preco' AND :direction = 'ASC' THEN preco END ASC, " +
            "CASE WHEN :orderBy = 'preco' AND :direction = 'DESC' THEN preco END DESC",
            nativeQuery = true)
    List<Livro> findAllSorted(@Param("orderBy") String orderBy, @Param("direction") String direction);

    @Query("SELECT l FROM Livro l WHERE l.preco > ALL (" +
            "SELECT l2.preco FROM Livro l2 WHERE l2.editora.idEditora = :editoraId)")
    List<Livro> findLivrosComPrecoMaiorQueTodosDaEditora(@Param("editoraId") int editoraId);

    @Query("SELECT e.quantidade FROM Estoque e WHERE e.livro.idLivro = :idLivro")
    Integer findQuantidadeEstoque(@Param("idLivro") int idLivro);





}