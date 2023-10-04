package com.example.springbootjava.controller;

import com.example.springbootjava.dto.ItemDto;
import com.example.springbootjava.entity.Item;
import com.example.springbootjava.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("itens")
@RequiredArgsConstructor
@Tag(name = "controle-total", description = "Gerenciar itens do estoque")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("teste")
    @Operation(summary = "Valida se a API foi inicializada com sucesso.")
    public String teste() {
        return "Estou funcionando!";
    }

    @GetMapping
    public ResponseEntity<List<Item>> buscarTodosOsItens() {
        List<Item> itens = itemService.buscaTodosOsItens();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Item> buscarItemPorNomeOuId(@RequestParam(required = false) Long id,
                                                      @RequestParam(required = false) String nome) {
        return ResponseEntity.ok(itemService.buscaItem(id, nome));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Item> cadastrarItem(@Valid @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.cadastraItem(itemDto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.atualizaItem(id, itemDto));
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarItem(@PathVariable Long id) {
        itemService.deletaItem(id);
    }
}
