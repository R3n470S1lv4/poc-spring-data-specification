package com.br.poc.controller.dto;

import com.br.poc.domain.Endereco;

public record EnderecoRequest(
    String estado,
    String cidade,
    String logradouro,
    String numero,
    String bairro
) {

  public Endereco of() {
    return new Endereco(
        this.estado,
        this.cidade,
        this.logradouro,
        this.numero,
        this.bairro
    );
  }

}
