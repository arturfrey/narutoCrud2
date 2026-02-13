package com.artur.db.narutoCrud2.ServiceTests;

import com.artur.db.narutoCrud2.model.NinjaDeNinjutsu;
import com.artur.db.narutoCrud2.model.NinjaDeTaijutsu;
import com.artur.db.narutoCrud2.model.Personagem;
import com.artur.db.narutoCrud2.repository.PersonagemRepository;
import com.artur.db.narutoCrud2.service.PersonagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    private PersonagemRepository repository;

    private PersonagemService service;

    @BeforeEach
    void setup() {
        service = new PersonagemService(repository);

        when(repository.save(any()))
                .thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    void deveCriarPersonagem() {
        Personagem personagem = service.criarPersonagem("Naruto");

        assertNotNull(personagem);
        assertEquals("Naruto", personagem.getNome());
        assertEquals(100, personagem.getVida());
    }

    @Test
    void deveCriarNinjaDeNinjutsu() {
        NinjaDeNinjutsu ninja = service.criarNinjaDeNinjutsu("Kakashi");

        assertNotNull(ninja);
        assertEquals("Kakashi", ninja.getNome());
        assertEquals(100, ninja.getVida());
    }

    @Test
    void deveCriarNinjaDeTaijutsu() {
        NinjaDeTaijutsu ninja = service.criarNinjaDeTaijutsu("Rock Lee");

        assertNotNull(ninja);
        assertEquals("Rock Lee", ninja.getNome());
        assertEquals(100, ninja.getVida());
    }
}
