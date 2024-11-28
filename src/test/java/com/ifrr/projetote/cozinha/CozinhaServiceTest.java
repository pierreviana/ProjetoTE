package com.ifrr.projetote.cozinha;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ifrr.projetote.model.Cozinha;
import com.ifrr.projetote.repository.CozinhaRepository;
import com.ifrr.projetote.service.CozinhaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CozinhaServiceTest {

    @Mock
    private CozinhaRepository cozinhaRepository;

    @InjectMocks
    private CozinhaService cozinhaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void inserirDeveRetornarCozinhaSalva() {
        Cozinha cozinha = new Cozinha();
        cozinha.setNome("Italiana");

        when(cozinhaRepository.inserir(cozinha)).thenReturn(cozinha);

        Cozinha cozinhaSalva = cozinhaService.inserir(cozinha);

        assertNotNull(cozinhaSalva);
        assertEquals("Italiana", cozinhaSalva.getNome());
        verify(cozinhaRepository).inserir(cozinha);
    }

    @Test
    void excluirDeveChamarMetodoDeletarDoRepositorio() {
        Long codigo = 1L;
        doNothing().when(cozinhaRepository).deletar(codigo);

        cozinhaService.excluir(codigo);

        verify(cozinhaRepository).deletar(codigo);
    }
}
