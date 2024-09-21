package com.br.poc.repository;

import com.br.poc.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PessoaRespository extends JpaRepository<Pessoa, Long>,
    JpaSpecificationExecutor<Pessoa> {

}