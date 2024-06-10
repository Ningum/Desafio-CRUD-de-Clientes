package br.com.desafiocruddeclientes.cruddeclientes.dto;

import br.com.desafiocruddeclientes.cruddeclientes.entities.Client;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class ClientDTO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(
    min = 6,
    max = 200,
    message = "O nome deve conter no mínimo 6 caracteres"
  )
  @NotBlank(message = "Campo requerido")
  private String name;

  @Column(unique = true)
  @Pattern(
    regexp = "^[0-9]{11}$",
    message = "O campo deve conter 11 caracteres numéricos"
  )
  @NotBlank(message = "Campo requerido")
  private String cpf;

  @Positive
  @NotBlank(message = "Campo requerido")
  private Double income;

  @PastOrPresent
  @NotBlank(message = "Campo requerido")
  private LocalDate birthDate;

  @Positive
  @NotBlank(message = "Campo requerido")
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
