package Desafio.biblioteca.Modelo;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id")
        Long id,

        @JsonAlias("title")
         String titulo,

         @JsonAlias("authors")
         List<DatosAutor> autores,

         @JsonAlias("languages")
         List<DatosIdioma> idiomas,

         @JsonAlias("download_count")
         Integer numeroDescargas)
{
}