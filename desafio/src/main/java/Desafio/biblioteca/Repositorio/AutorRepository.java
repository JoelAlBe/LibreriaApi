package Desafio.biblioteca.Repositorio;

import Desafio.biblioteca.Modelo.Autor;
import Desafio.biblioteca.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>
{
    List<Autor> findByFechaNacimientoLessThanEqualAndFechaMuerteGreaterThanEqual(String fechaNacimiento, String fechaMuerte);
    List<Autor> findByFechaMuerteIsNullOrFechaMuerteGreaterThanEqual(String fechaMuerte);
    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento > :fecha OR a.fechaMuerte IS NULL")
    List<Autor> buscarAutoresVivos(@Param("fecha") Integer fecha);

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> buscarLibrosPorIdioma(@Param("idioma") String idioma);

    @Query("SELECT l FROM Libro l")
    List<Libro> buscarTodosLosLibros();

    @Query("SELECT a FROM Autor a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Autor> buscarAutorPorNombre(@Param("nombre") String nombre);
}