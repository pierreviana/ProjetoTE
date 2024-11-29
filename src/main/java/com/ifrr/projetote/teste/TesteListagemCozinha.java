package com.ifrr.projetote.teste;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrr.projetote.ProjetoTeApplication;
import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.repository.CozinhaRepository;
import com.ifrr.projetote.repository.CozinhaRepositoryImpl;

public class TesteListagemCozinha {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoTeApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
	
		
		CozinhaRepository cozinhaJPA = applicationContext.getBean(CozinhaRepositoryImpl.class);
		List<Cozinha> cozinhas = cozinhaJPA.listar();
		for (Cozinha cozinha : cozinhas) {
			System.out.println(cozinha.getNome());
		}
	}
}
//fdfdfd
//fdfd
