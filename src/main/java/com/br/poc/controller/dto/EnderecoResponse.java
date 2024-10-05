package com.br.poc.controller.dto;

import com.br.poc.domain.Endereco;

public record EnderecoResponse(
    String estado,
    String cidade,
    String logradouro,
    String numero,
    String bairro
) {

  public static EnderecoResponse of(Endereco endereco) {
    return new EnderecoResponse(
        endereco.getEstado(),
        endereco.getCidade(),
        endereco.getLogradouro(),
        endereco.getNumero(),
        endereco.getBairro()
    );
  }

}
