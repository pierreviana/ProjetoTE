package com.ifrr.projetote.teste;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifrr.projetote.ProjetoTeApplication;
import com.ifrr.projetote.model.Cliente;
import com.ifrr.projetote.repository.ClienteRepository;

public class TesteInsercaoCliente {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoTeApplication.class)
				.web(WebApplicationType.NONE).run(args);

		ClienteRepository clienteRepository = applicationContext.getBean(ClienteRepository.class);
	    List<Cliente> clientes = clienteRepository.listar();
	    for (Cliente c: clientes) {
	    	System.out.println(c.getCodigo());
	    }
		
	}
//Adicionado novo comentário
//Adicionado mais um comentário
	//dsdsdsds
}
