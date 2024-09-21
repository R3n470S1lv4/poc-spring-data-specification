package com.br.poc.service;

import com.br.poc.domain.Pessoa;
import com.br.poc.repository.PessoaRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertPessoaService {

  private final PessoaRespository pessoaRespository;

  public Pessoa insert(Pessoa pessoa) {
    return pessoaRespository.save(pessoa);
  }

}
