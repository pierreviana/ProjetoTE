package com.ifrr.projetote.teste;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrr.projetote.ProjetoTeApplication;
import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.model.Restaurante;
import com.ifrr.projetote.repository.CozinhaRepository;
import com.ifrr.projetote.repository.CozinhaRepositoryImpl;
import com.ifrr.projetote.repository.RestauranteJPA;

public class TesteInsercaoRestaurante {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoTeApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhaJPA = applicationContext.getBean(CozinhaRepositoryImpl.class);
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Italiana");
		restaurante.setCozinha((Cozinha)cozinhaJPA.selecionar(1l));

		RestauranteJPA restauranteJPA = applicationContext.getBean(RestauranteJPA.class);
		restauranteJPA.inserir(restaurante);

	}
}
