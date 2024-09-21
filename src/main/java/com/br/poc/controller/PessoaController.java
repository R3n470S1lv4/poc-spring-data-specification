package com.br.poc.controller;


import com.br.poc.controller.dto.PessoaRequest;
import com.br.poc.controller.dto.PessoaResponse;
import com.br.poc.domain.Pessoa;
import com.br.poc.domain.PessoaSpecification;
import com.br.poc.service.BuscaPessoaService;
import com.br.poc.service.InsertPessoaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

  private final InsertPessoaService insertPessoaService;
  private final BuscaPessoaService buscaPessoaService;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody PessoaRequest request) {
    Pessoa savedPessoa = insertPessoaService.insert(request.of());
    return ResponseEntity.created(ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedPessoa.getPessoaId()).toUri())
        .build();
  }

  @GetMapping
  public ResponseEntity<List<PessoaResponse>> find(PessoaSpecification queryParamenter) {
    List<PessoaResponse> responses = buscaPessoaService.buscar(queryParamenter)
        .stream()
        .map(PessoaResponse::of)
        .toList();

    return ResponseEntity.ok(responses);
  }

}
