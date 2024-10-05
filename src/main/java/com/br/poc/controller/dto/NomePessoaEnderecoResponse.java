package com.br.poc.controller.dto;

import com.br.poc.repository.NomePessoaEnderecoProjection;
import java.time.LocalDate;

public record NomePessoaEnderecoResponse(
    String nomeCompleto,
    LocalDate dataNascimento,
    EnderecoResponse endereco
) {

  public static NomePessoaEnderecoResponse of(
      NomePessoaEnderecoProjection nomePessoaEnderecoProjection) {
    return new NomePessoaEnderecoResponse(
        nomePessoaEnderecoProjection.getNome(),
        nomePessoaEnderecoProjection.getDataNascimento(),
        EnderecoResponse.of(nomePessoaEnderecoProjection.getEndereco())
    );
  }
}
