package br.com.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(value = "br.com.desafio.modelos")
public class Configuracao {
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
}
	