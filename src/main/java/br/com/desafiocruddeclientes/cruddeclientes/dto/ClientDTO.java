package br.com.desafiocruddeclientes.cruddeclientes.dto;

import br.com.desafiocruddeclientes.cruddeclientes.entities.Client;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

public class ClientDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(unique = true)
  private String cpf;

  private Double income;
  private LocalDate birthDate;
  private Integer children;

  public ClientDTO(
    Long id,
    String name,
    String cpf,
    Double income,
    LocalDate birthDate,
    Integer children
  ) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.income = income;
    this.birthDate = birthDate;
    this.children = children;
  }

  public ClientDTO(Client entity) {
    id = entity.getId();
    name = entity.getName();
    cpf = entity.getCpf();
    income = entity.getIncome();
    birthDate = entity.getBirthDate();
    children = entity.getChildren();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCpf() {
    return cpf;
  }

  public Double getIncome() {
    return income;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public Integer getChildren() {
    return children;
  }
}
