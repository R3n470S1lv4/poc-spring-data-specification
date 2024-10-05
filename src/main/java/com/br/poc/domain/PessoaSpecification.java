package com.br.poc.domain;

import static java.util.Objects.nonNull;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class PessoaSpecification implements Specification<Pessoa> {

  private final String nome;
  private final String sobreNome;

  @Override
  public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {

    List<Predicate> predicates = new ArrayList<>();

    if (nonNull(this.nome)) {
      predicates.add(porNome(root, criteriaBuilder));
    }
    if (nonNull(this.sobreNome)) {
      predicates.add(porSobrenome(root, criteriaBuilder));
    }

    return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
  }

  private Predicate porSobrenome(Root<Pessoa> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder
        .equal(root.get("sobreNome"), sobreNome);
  }

  private Predicate porNome(Root<Pessoa> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.like(root.get("nomeCompleto"), nome);
  }

}
