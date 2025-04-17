package com.jpnoronha.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Bem-vindo ao Cadastro de Ninjas!";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Criado com sucesso!";
    }

    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Mostrar todos os ninjas!";
    }

    @GetMapping("/ninja-id")
    public String mostrarNinjaPorId() {
        return "Mostra ninja por id";
    }

    @PutMapping("/alterar")
    public String alterarNinjaPorId() {
        return "Alterar ninja por id";
    }

    @DeleteMapping("/deletar")
    public String deletarNinjaPorId() {
        return "Deletar ninja por id";
    }
}
