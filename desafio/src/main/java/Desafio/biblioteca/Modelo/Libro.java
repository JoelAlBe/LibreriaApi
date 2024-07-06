package Desafio.biblioteca.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "numero_descargas")
    private Integer numeroDescargas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autores;

    public Libro(DatosLibro datosLibro, Autor autor)
    {
        titulo = datosLibro.titulo();

        if(datosLibro.idiomas().isEmpty())
        {
            idioma = "Idioma sin identificar";
        }

        else
        {
            idioma = (String) datosLibro.idiomas().get(0).idioma();
        }

        numeroDescargas = Integer.valueOf(datosLibro.numeroDescargas());
        autores = autor;
    }

    public Libro()
    {
        //Constructor vacio.
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public Autor getAutores()
    {
        return autores;
    }

    public void setAutores(Autor autores)
    {
        this.autores = autores;
    }

    public String getIdioma()
    {
        return idioma;
    }

    public void setIdioma(String idioma)
    {
        this.idioma = idioma;
    }

    public Integer getNumeroDescargas()
    {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas)
    {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString()
    {
        return "\n----------------------------------------- \n" +
                "Libro \n" +
                "Titulo: '" + titulo + "'\n" +
                "Autor(es): '" + autores.getNombre() + "'\n" +
                "Idioma: '" + idioma + "'\n" +
                "Numero de descargas: " + numeroDescargas + "\n" +
                "----------------------------------------- \n";
    }
}