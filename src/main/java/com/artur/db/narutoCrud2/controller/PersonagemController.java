package com.artur.db.narutoCrud2.controller;

import com.artur.db.narutoCrud2.model.NinjaDeNinjutsu;
import com.artur.db.narutoCrud2.model.NinjaDeTaijutsu;
import com.artur.db.narutoCrud2.model.Personagem;
import com.artur.db.narutoCrud2.service.PersonagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

    @RestController
    @RequestMapping("/personagens")
    public class PersonagemController {

        private final PersonagemService service;

        public PersonagemController(PersonagemService service) {
            this.service = service;
        }

        @PostMapping("/personagem")
        public ResponseEntity<Personagem> criarPersonagem(
                @RequestParam String nome
        ) {
            return ResponseEntity.ok(service.criarPersonagem(nome));
        }

        @PostMapping("/ninjutsu")
        public ResponseEntity<NinjaDeNinjutsu> criarNinjaDeNinjutsu(
                @RequestParam String nome
        ) {
            return ResponseEntity.ok(service.criarNinjaDeNinjutsu(nome));
        }

        @PostMapping("/taijutsu")
        public ResponseEntity<NinjaDeTaijutsu> criarNinjaDeTaijutsu(
                @RequestParam String nome
        ) {
            return ResponseEntity.ok(service.criarNinjaDeTaijutsu(nome));
        }
    }
