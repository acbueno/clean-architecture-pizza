package br.acbueno.clean.architecture.pizza.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequestDTO {

  private Long customerId;

  private List<OrderItemRequestDTO> items;

}
