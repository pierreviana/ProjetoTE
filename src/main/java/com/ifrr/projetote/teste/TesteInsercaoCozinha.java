package com.ifrr.projetote.teste;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrr.projetote.ProjetoTeApplication;
import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.repository.CozinhaRepository;
import com.ifrr.projetote.repository.CozinhaRepositoryImpl;

public class TesteInsercaoCozinha {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoTeApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setNome("Italiana");
		
		CozinhaRepository cozinhaJPA = applicationContext.getBean(CozinhaRepositoryImpl.class);
		cozinhaJPA.inserir(cozinha);
		
	}
}
//teste2
//teste3
