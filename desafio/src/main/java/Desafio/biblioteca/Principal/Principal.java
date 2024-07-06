package Desafio.biblioteca.Principal;

import Desafio.biblioteca.Modelo.Autor;
import Desafio.biblioteca.Modelo.Datos;
import Desafio.biblioteca.Modelo.DatosLibro;
import Desafio.biblioteca.Modelo.Libro;
import Desafio.biblioteca.Repositorio.AutorRepository;
import Desafio.biblioteca.Repositorio.LibroRepository;
import Desafio.biblioteca.Service.ConsumoAPI;
import Desafio.biblioteca.Service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Principal
{
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConvierteDatos convierte = new ConvierteDatos();
    private String URL_BASE = "https://gutendex.com/books/?search=";
    private LibroRepository libroRepositorio;
    private AutorRepository autorRepositorio;

    @Autowired
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository)
    {
        libroRepositorio = libroRepository;
        autorRepositorio = autorRepository;
    }

    public void mostrarMenu()
    {
        var opcion = -1;
        var menu = """
                \nLibreria Alura. Por favor seleccione una opcion:
                1.- Buscar libro por titulo...
                2.- Lista de libros registrados...
                3.- Lista de autores registrados...
                4.- Lista de autores vivos por fechas registrados...
                5.- Lista de libros por idioma...
                0.- Salir...
                """;

        while(opcion != 0)
        {
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion)
            {
                case 1:
                    buscarLibroPorTitulo();
                break;

                case 2:
                    mostrarLibrosregistrados();
                break;

                case 3:
                    mostrarAutoresRegistrados();
                break;

                case 4:
                    mostrarAutoresVivos();
                break;

                case 5:
                    mostrarMenuIdiomas();
                break;

                case 0:
                    System.out.println("\nSaliendo...\n");
                break;

                default:
                    System.out.println("\nLa opcion que ingreso es erronea, pruebe con otra opcion...\n");
                break;
            }
        }
    }

    private DatosLibro getLibros()
    {
        System.out.println("Ingrese el titulo del libro a buscar:");
        var titulo = teclado.nextLine();
        var json = consumo.obtenerDatos(URL_BASE+titulo.replace(" ", "+").toLowerCase());
        var datos = convierte.obtenerDatos(json, Datos.class);

        if(datos.libros() != null && !datos.libros().isEmpty())
        {
            return datos.libros().get(0);
        }

        System.out.println("\nEl libro que desea localizar no se encuentra disponible");
        return null;
    }

    private void buscarLibroPorTitulo()
    {
        DatosLibro datosLibro = getLibros();

        if(datosLibro != null)
        {
            Autor autor = datosLibro.autores().stream()
                    .map(datosAutor ->
                    {
                        Autor a = autorRepositorio.findByNombre(datosAutor.nombre());

                        if(a != null)
                        {
                            return a;
                        }

                        else
                        {
                            Autor autor1 =new Autor(datosAutor);
                            return autorRepositorio.save(autor1);
                        }
                    })
                    .findFirst().orElse(null);

            if(autor != null)
            {
                List<Libro> librosAlmacenados = libroRepositorio.findByTitulo(datosLibro.titulo());
                if (!librosAlmacenados.isEmpty())
                {
                    librosAlmacenados.get(0);
                }
                Libro libro = new Libro(datosLibro, autor);
                libroRepositorio.save(libro);
                System.out.println(libro);
            }

            else
            {
                System.out.println("El titulo que ingreso no se encuentra disponible...");
            }
        }
    }

    public void mostrarLibrosregistrados()
    {
        System.out.println("Libros registrados en la base de datos: ");
        List<Libro> libros = libroRepositorio.findAll();

        if (!libros.isEmpty())
        {
            libros.forEach(System.out::println);
        }

        else
        {
            System.out.println("\n________________________________________________");
            System.out.println(" No hay libros registrados en la base de datos. ");
            System.out.println("________________________________________________\n");
        }
    }

    private void mostrarAutoresRegistrados()
    {
        System.out.println("Autores registrados en la base de datos: ");
        List<Autor> autores = autorRepositorio.findAll();

        if (!autores.isEmpty())
        {
            autores.forEach(System.out::println);
        }

        else
        {
            System.out.println("\n________________________________________________");
            System.out.println(" No hay autores registrados en la base de datos. ");
            System.out.println("________________________________________________\n");
        }
    }

    private void mostrarAutoresVivos()
    {
        System.out.println("Escribe el año que quieras saber qué autor estaba vivo: ");
        String fecha = teclado.nextLine();
        List<Autor> autores = autorRepositorio.findByFechaNacimientoLessThanEqualAndFechaMuerteGreaterThanEqual(fecha, fecha);

        if (autores.isEmpty())
        {
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("No hay autores el la base de datos que correspondan a la fecha ingresada...");
            System.out.println("-------------------------------------------------------------------------\n");
        }

        else
        {
            autores.forEach(System.out::println);
        }
    }

    public void mostrarMenuIdiomas()
    {
        int opcionIdioma = -1;
        String idioma;
        String abreviatura;

        var subMenu = """
                    \nSeleccione un idioma:
                    1. Español...
                    2. Francés...
                    3. Inglés...
                    4. Portugués...
                    0. Volver al menú principal
                    ------------------------------
                    """;

        while (opcionIdioma != 0)
        {
            System.out.println(subMenu);
            opcionIdioma = teclado.nextInt();
            teclado.nextLine();

            switch (opcionIdioma)
            {
                case 1:
                    idioma = "Español";
                    abreviatura = "es";
                    mostrarLibrosPorIdioma(idioma, abreviatura);
                break;

                case 2:
                    idioma = "Frances";
                    abreviatura = "fr";
                    mostrarLibrosPorIdioma(idioma, abreviatura);
                break;

                case 3:
                    idioma = "Ingles";
                    abreviatura = "en";
                    mostrarLibrosPorIdioma(idioma, abreviatura);
                break;

                case 4:
                    idioma = "Portugues";
                    abreviatura = "pt";
                    mostrarLibrosPorIdioma(idioma, abreviatura);
                break;

                case 0:
                    System.out.println("Regresando al menu principal...");
                break;

                default:
                    System.out.println("La opcion ingresada no es valida....");
                break;
            }
        }
    }

    private void mostrarLibrosPorIdioma(String idioma, String abreviatura)
    {
        List<Libro> libros = libroRepositorio.buscarLibrosPorIdioma(abreviatura);
        if (libros.isEmpty())
        {
            System.out.println("No se encontraron libros en la base de datos con el idioma " + idioma + "....");
        }

        else
        {
            System.out.println("Los libros en " + idioma + " que se encuentran en la base de datos son: ");
            libros.forEach(System.out::println);
        }
    }
}