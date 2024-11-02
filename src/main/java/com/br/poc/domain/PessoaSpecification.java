package com.br.poc.domain;

import static java.util.Objects.nonNull;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

@RequiredArgsConstructor
public class PessoaSpecification implements Specification<Pessoa> {

  private final String nome;
  private final String sobreNome;

  @Override
  public Predicate toPredicate(@NonNull Root<Pessoa> root, CriteriaQuery<?> query,
      @NonNull CriteriaBuilder criteriaBuilder) {

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
        .equal(criteriaBuilder.lower(root.get("sobreNome")), sobreNome.toLowerCase());
  }

  private Predicate porNome(Root<Pessoa> root, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")),
        "%".concat(nome.toLowerCase(Locale.ROOT)).concat("%"));
  }

}
