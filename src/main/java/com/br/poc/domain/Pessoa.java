package com.br.poc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq_generator")
  @SequenceGenerator(name = "pessoa_seq_generator", sequenceName = "pessoa_seq", allocationSize = 1)
  @Column(name = "PESSOA_ID")
  private Long pessoaId;
  @CreationTimestamp
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @UpdateTimestamp
  @Column(name = "UPDATED_AT")
  private LocalDateTime updatedAt;
  @Column(name = "NOME")
  private String nome;
  @Column(name = "SOBRE_NOME")
  private String sobreNome;
  @Column(name = "EMAIL")
  private String email;
  @Column(name = "DATA_NASCIMENTO")
  private LocalDate dataNascimento;

  private Pessoa() {
  }

  public Pessoa(String nome, String sobreNome, String email, LocalDate dataNascimento) {
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.email = email;
    this.dataNascimento = dataNascimento;
  }
}
