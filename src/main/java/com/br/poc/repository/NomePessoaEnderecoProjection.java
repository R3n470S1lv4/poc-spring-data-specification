package com.br.poc.repository;

import com.br.poc.domain.Endereco;
import java.time.LocalDate;

public interface NomePessoaEnderecoProjection {

  //@Value("#{target.nome} #{target.sobreNome}")
  //Acabou produzindo um sql que trouxe todos os camops de pessoa e
  // nao fez join com endereco
  String getNome();

  LocalDate getDataNascimento();

  Endereco getEndereco();

}
