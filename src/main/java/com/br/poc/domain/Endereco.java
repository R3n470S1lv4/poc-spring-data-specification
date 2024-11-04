package com.br.poc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@FieldNameConstants
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq_generator")
  @SequenceGenerator(name = "endereco_seq_generator", sequenceName = "endereco_seq", allocationSize = 1)
  @Column(name = "ENDERECO_ID")
  private Long enderecoId;
  @Column(name = "ESTADO")
  private String estado;
  @Column(name = "CIDADE")
  private String cidade;
  @Column(name = "LOGRADOURO")
  private String logradouro;
  @Column(name = "NUMERO")
  private String numero;
  @Column(name = "BAIRRO")
  private String bairro;
  @CreationTimestamp
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @UpdateTimestamp
  @Column(name = "UPDATED_AT")
  private LocalDateTime updatedAt;

  private Endereco() {
  }

  public Endereco(String estado, String cidade, String logradouro, String numero, String bairro) {
    this.estado = estado;
    this.cidade = cidade;
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
  }
}
