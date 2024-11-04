package com.br.poc.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.br.poc.domain.Endereco;
import com.br.poc.domain.EnderecoSpecification;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.domain.Specification;

@DataJpaTest
class EnderecoRepositoryTest {

  @Autowired
  EnderecoRepository enderecoRepository;

  @Autowired
  TestEntityManager entityManager;
  private Endereco endereco;

  @BeforeEach
  void setUp() {
    endereco = new Endereco("SP", "Santa Barbara DOeste", "Rua Amparo", "236",
        "Residencial Jardim Sao Joaquim");
  }

  @Test
  void deveBuscarPorCidade() {
    enderecoRepository.save(endereco);

    List<Endereco> sut = enderecoRepository.findAll(EnderecoSpecification.byCidade("Santa"));

    assertThat(sut).isNotEmpty().hasSize(1);
    assertThat(sut.get(0).getEstado()).isEqualTo("SP");
    assertThat(sut.get(0).getCidade()).isEqualTo("Santa Barbara DOeste");
  }

  @Test
  void deveBuscarPorCidadeEEstado() {
    enderecoRepository.save(endereco);

    Specification<Endereco> CidadeEEstado =
        Specification.where(EnderecoSpecification.byCidade("Santa"))
            .and(EnderecoSpecification.byEstado("sp"));

    List<Endereco> sut = enderecoRepository.findAll(CidadeEEstado);

    assertThat(sut).isNotEmpty().hasSize(1);
    assertThat(sut.get(0).getEstado()).isEqualTo("SP");
    assertThat(sut.get(0).getCidade()).isEqualTo("Santa Barbara DOeste");
  }

}