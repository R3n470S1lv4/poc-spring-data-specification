package com.br.poc.service;

import com.br.poc.domain.Pessoa;
import com.br.poc.domain.PessoaSpecification;
import com.br.poc.repository.PessoaRespository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuscaPessoaService {

  private final PessoaRespository pessoaRespository;

  public List<Pessoa> buscar(PessoaSpecification specification) {
    return pessoaRespository.findAll(specification);
  }
}
