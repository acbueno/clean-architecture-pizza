package br.acbueno.clean.architecture.pizza.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderResponseDTO {

  private Long id;

  private CustomerResponseDTO customer;

  private List<OrderItemResponseDTO> items;

  private double total;

}
