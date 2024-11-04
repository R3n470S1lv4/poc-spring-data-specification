package com.br.poc.domain;

import static java.util.Objects.requireNonNull;

import com.br.poc.domain.Endereco.Fields;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class EnderecoSpecification {

  private EnderecoSpecification() {
  }

  public static Specification<Endereco> byEstado(String estado) {
    requireNonNull(estado);

    return (Root<Endereco> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.equal(
        criteriaBuilder.lower(root.get(Fields.estado)), estado.toLowerCase()
    );
  }

  public static Specification<Endereco> byCidade(String cidade) {
    requireNonNull(cidade);

    return (Root<Endereco> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.like(
        criteriaBuilder.lower(root.get(Fields.cidade)), "%".concat(cidade.toLowerCase()).concat("%")
    );
  }
}
