package Desafio.biblioteca.Service;

public interface IConvierteDatos
{
    <L> L obtenerDatos(String json, Class<L> clase);
}