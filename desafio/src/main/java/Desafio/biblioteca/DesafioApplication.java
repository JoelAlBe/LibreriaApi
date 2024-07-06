package Desafio.biblioteca;

import Desafio.biblioteca.Principal.Principal;
import Desafio.biblioteca.Repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner
{
	@Autowired
	private Principal principal;

	public static void main(String[] args)
	{
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		principal.mostrarMenu();
	}
}