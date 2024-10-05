package com.br.poc.controller.dto;

import com.br.poc.domain.Pessoa;
import java.time.LocalDate;

public record PessoaRequest(
    String nome,
    String sobreNome,
    String email,
    LocalDate dataNascimento,
    EnderecoRequest endereco
) {

  public Pessoa of() {
    return new Pessoa(this.nome, this.sobreNome, this.email, this.dataNascimento, endereco.of());
  }
}
