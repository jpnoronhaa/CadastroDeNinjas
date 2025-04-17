package com.jpnoronha.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Lista de missoes";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Criado com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Deletado com sucesso!";
    }
}
