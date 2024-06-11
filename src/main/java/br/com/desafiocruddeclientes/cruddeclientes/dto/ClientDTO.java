package br.com.desafiocruddeclientes.cruddeclientes.dto;

import br.com.desafiocruddeclientes.cruddeclientes.entities.Client;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class ClientDTO {

  private Long id;

  @Size(
    min = 6,
    max = 200,
    message = "O nome deve conter no mínimo 6 caracteres"
  )
  @NotBlank(message = "Campo requerido")
  private String name;

  @Size(
    min = 11,
    max = 11,
    message = "O campo deve conter 11 caracteres numéricos"
  )
  @NotBlank(message = "Campo requerido")
  private String cpf;

  @Min(value = 0, message = "Campo deve ser igual ou maior que zero")
  private Double income;

  @PastOrPresent(message = "Informe uma data de nascimento válida")
  private LocalDate birthDate;

  @Min(value = 0, message = "Campo deve ser igual ou maior que zero")
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
