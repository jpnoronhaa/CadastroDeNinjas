package com.jpnoronha.cadastrodeninjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listagem de missões", description = "Lista todas as missões da base de dados.")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de ninjas retornada com sucesso.",
            content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MissaoDTO.class))
                    )
            }
    )
    public ResponseEntity<List<MissaoDTO>> listar() {
        List<MissaoDTO> missoes = service.getAll();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Buscar missão por ID", description = "Busca uma missão na base de dados pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Missão encontrada com sucesso",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MissaoDTO.class)
                            )
                    }),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada.")
    })
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {
        MissaoDTO missao = service.getById(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao de ID " + id + " não foi encontrada.");
    }

    @PostMapping("/criar")
    @Operation(summary = "Cadastrar nova missão", description = "Cadastra uma nova missão na base de dados e a retorna.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Missão cadastrada com sucesso.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MissaoDTO.class)
                            )
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Missão não pode ser cadastrada.")
    })
    public ResponseEntity<?> criarMissao(@RequestBody MissaoDTO missaoDTO) {
        MissaoDTO created = service.save(missaoDTO);
        if (created != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missão não pode ser cadastrada.");
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Atualizar missão", description = "Atualiza os dados de uma missão pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Missão atualizada com sucesso.",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = MissaoDTO.class)
                            )
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar missao."),
            @ApiResponse(responseCode = "404", description = "Missão não foi encontrada.")
    })
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        MissaoDTO missao = service.getById(id);
        if (missao != null) {
            MissaoDTO updated = service.update(id, missaoDTO);
            if (updated != null) {
                return ResponseEntity.ok(updated);
            }
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de ID " + id + " não foi encontrada.");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar missão", description = "Deleta missão na base de dados.")
    @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso.")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Missão deletada com sucesso.");
    }
}
