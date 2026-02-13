package com.artur.db.narutoCrud2.controllerTests.Integrations;

import com.artur.db.narutoCrud2.controller.PersonagemController;
import com.artur.db.narutoCrud2.model.Personagem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonagemControllerIT {

    @Autowired
    private PersonagemController controller;

    @Test
    void deveCriarPersonagemPelaController() {
        ResponseEntity<Personagem> response =
                controller.criarPersonagem("Sasuke");

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Sasuke", response.getBody().getNome());
    }
}

