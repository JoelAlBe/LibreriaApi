package Desafio.biblioteca.Repositorio;

import Desafio.biblioteca.Modelo.Libro;
import Desafio.biblioteca.Modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long>
{
    Optional<Libro> findById(Long id);
    List<Libro> findByTitulo(String titulo);
    List<Libro> findByIdioma(String idioma);

    @Query("SELECT l.autores FROM Libro l WHERE l.autores.nombre LIKE %:nombre%")
    List<Autor> buscarAutorPorNombre(@Param("nombre") String nombre);

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:titulo%")
    Optional<Libro> buscarLibroPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> buscarLibrosPorIdioma(@Param("idioma") String idioma);
}