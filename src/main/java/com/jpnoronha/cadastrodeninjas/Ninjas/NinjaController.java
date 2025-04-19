package com.jpnoronha.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Criado com sucesso!";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel buscarNinjaPorId(@PathVariable Long id) {
        NinjaModel ninja = ninjaService.buscarNinjaPorId(id);
        if (ninja != null) {
            return ninja;
        }
        return null;
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
