package com.ifrr.projetote;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.service.CozinhaService;

@SpringBootTest
class ProjetoTeApplicationTests {

	@Autowired
	private CozinhaService cozinhaService;
	
	@Test
	public void testarCadastroCozinhaComSucesso() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		// ação
		novaCozinha = cozinhaService.inserir(novaCozinha);
		
		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getCodigo()).isNotNull();
	}
	
	

	/*
	 * @Test void shouldThrowConstraintViolationException() {
	 * assertThrows(ConstraintViolationException.class, () -> { // Chame o método
	 * que deve lançar a exceção aqui testarCadastroCozinhaComSucesso(); }); }
	 */


	public void testarCadastroCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		novaCozinha = cozinhaService.inserir(novaCozinha);
	}

}
