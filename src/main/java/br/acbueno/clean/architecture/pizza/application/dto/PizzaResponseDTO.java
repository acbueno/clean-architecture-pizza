package br.acbueno.clean.architecture.pizza.application.dto;

import br.acbueno.clean.architecture.pizza.application.enums.SizePizza;
import lombok.Data;

@Data
public class PizzaResponseDTO {

  private Long id;

  private String name;

  private SizePizza sizePizza;

  private double price;

}
