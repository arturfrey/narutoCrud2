package com.artur.db.narutoCrud2.ServiceTests.Integrations;

import com.artur.db.narutoCrud2.model.Personagem;
import com.artur.db.narutoCrud2.service.PersonagemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonagemServiceIT {

    @Autowired
    private PersonagemService service;

    @Test
    void deveCriarPersonagemNoBanco() {
        Personagem personagem = service.criarPersonagem("Naruto");

        assertNotNull(personagem);
        assertNotNull(personagem.getId());
        assertEquals("Naruto", personagem.getNome());
        assertEquals(100, personagem.getVida());
    }
}