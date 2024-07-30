package br.acbueno.clean.architecture.pizza.application.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {

  private Long id;

  private String name;

  private String email;

  private String phoneNumber;

}
