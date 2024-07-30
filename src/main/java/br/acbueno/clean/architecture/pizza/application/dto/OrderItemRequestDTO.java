package br.acbueno.clean.architecture.pizza.application.dto;

import lombok.Data;

@Data
public class OrderItemRequestDTO {

  private Long pizzaId;

  private int quantity;

}
