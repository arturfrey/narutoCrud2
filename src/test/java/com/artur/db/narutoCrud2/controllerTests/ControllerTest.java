package com.artur.db.narutoCrud2.controllerTests;

import com.artur.db.narutoCrud2.controller.PersonagemController;
import com.artur.db.narutoCrud2.model.NinjaDeNinjutsu;
import com.artur.db.narutoCrud2.model.NinjaDeTaijutsu;
import com.artur.db.narutoCrud2.model.Personagem;
import com.artur.db.narutoCrud2.service.PersonagemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @Mock
    private PersonagemService service;

    @InjectMocks
    private PersonagemController controller;

    @Test
    void deveCriarPersonagemViaController() {
        Personagem personagem = new Personagem("Naruto");
        when(service.criarPersonagem("Naruto")).thenReturn(personagem);

        ResponseEntity<Personagem> response =
                controller.criarPersonagem("Naruto");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Naruto", response.getBody().getNome());

        verify(service).criarPersonagem("Naruto");
    }

    @Test
    void deveCriarNinjaDeNinjutsuViaController() {
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        ninja.setNome("Kakashi");

        when(service.criarNinjaDeNinjutsu("Kakashi")).thenReturn(ninja);

        ResponseEntity<NinjaDeNinjutsu> response =
                controller.criarNinjaDeNinjutsu("Kakashi");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Kakashi", response.getBody().getNome());

        verify(service).criarNinjaDeNinjutsu("Kakashi");
    }

    @Test
    void deveCriarNinjaDeTaijutsuViaController() {
        NinjaDeTaijutsu ninja = new NinjaDeTaijutsu();
        ninja.setNome("Rock Lee");

        when(service.criarNinjaDeTaijutsu("Rock Lee")).thenReturn(ninja);

        ResponseEntity<NinjaDeTaijutsu> response =
                controller.criarNinjaDeTaijutsu("Rock Lee");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Rock Lee", response.getBody().getNome());

        verify(service).criarNinjaDeTaijutsu("Rock Lee");
    }
}

