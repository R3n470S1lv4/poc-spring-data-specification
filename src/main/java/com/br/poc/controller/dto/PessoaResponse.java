package com.br.poc.controller.dto;

import com.br.poc.domain.Pessoa;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PessoaResponse(
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    String nome,
    String sobreNome,
    String email,
    LocalDate dataNascimento
) {

  public static PessoaResponse of(Pessoa pessoa) {
    return new PessoaResponse(
        pessoa.getCreatedAt(),
        pessoa.getUpdatedAt(),
        pessoa.getNome(),
        pessoa.getSobreNome(),
        pessoa.getEmail(),
        pessoa.getDataNascimento()
    );
  }
}
