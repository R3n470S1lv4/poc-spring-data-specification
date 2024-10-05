package com.br.poc.controller.dto;

import com.br.poc.repository.NomePessoaEnderecoProjection;

public record NomePessoaEnderecoResponse(
    String nome,
    EnderecoResponse endereco
) {

  public static NomePessoaEnderecoResponse of(
      NomePessoaEnderecoProjection nomePessoaEnderecoProjection) {
    return new NomePessoaEnderecoResponse(
        nomePessoaEnderecoProjection.getNome(),
        EnderecoResponse.of(nomePessoaEnderecoProjection.getEndereco())
    );
  }
}
