package br.acbueno.clean.architecture.pizza.application.dto;

import br.acbueno.clean.architecture.pizza.application.enums.SizePizza;
import lombok.Data;

@Data
public class OrderItemResponseDTO {

  private Long pizzaId;

  private int quantity;

  private SizePizza sizePizza;

}
