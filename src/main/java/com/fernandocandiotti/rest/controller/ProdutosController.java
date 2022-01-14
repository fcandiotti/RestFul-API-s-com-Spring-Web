package com.fernandocandiotti.rest.controller;

import com.fernandocandiotti.domain.entity.Produto;
import com.fernandocandiotti.domain.repository.ProdutoRepository;
import com.fernandocandiotti.rest.dto.InformacoesItemPedidoDTO;
import com.fernandocandiotti.rest.dto.InformacoesPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id,
                       @RequestBody @Valid  Produto produto) {
        produtoRepository
                .findById(id)
                .map(pedidoExistente -> {
                    produto.setId(pedidoExistente.getId());
                    produtoRepository.save(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pedido não encontrado"));
    }

    @DeleteMapping({"id"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        produtoRepository.findById(id)
                .map(produto -> {
                    produtoRepository.delete(produto);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto Não Encontrado"));
    }

    @GetMapping("{id}")
    public Produto getProdutoById(@PathVariable Integer id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Produto Não Encontrado"));
    }

     @GetMapping
     public List<Produto> find(Produto filtro) {
         ExampleMatcher matcher = ExampleMatcher
                 .matching()
                 .withIgnoreCase()
                 .withStringMatcher(
                         ExampleMatcher.StringMatcher.CONTAINING);
         Example example = Example.of(filtro, matcher);
         return produtoRepository.findAll(example);
     }

}
