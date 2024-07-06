package Desafio.biblioteca.Modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @JsonAlias("fecha_nacimiento")
    private String fechaNacimiento;

    @JsonAlias("fecha_muerte")
    private String fechaMuerte;

    @OneToMany(mappedBy = "autores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;

    public Autor(DatosAutor datosAutor)
    {
        nombre = datosAutor.nombre();
        fechaNacimiento = datosAutor.fechaNacimiento();
        fechaMuerte = datosAutor.fechaMuerte();
    }

    public Autor()
    {
        //Constructor vacio...
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaMuerte()
    {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte)
    {
        this.fechaMuerte = fechaMuerte;
    }

    public List<Libro> getLibro()
    {
        return libro;
    }

    public void setLibro(List<Libro> libro)
    {
        this.libro = libro;
    }

    @Override
    public String toString()
    {
        return "\n----------------------------------------- \n" +
                "Autor: \n" +
                "Nombre: " + nombre + "\n" +
                "Fecha de nacimiento: " + fechaNacimiento + "\n" +
                "Fecha de muerte: " + fechaMuerte +
                "\n----------------------------------------- \n";
    }
}