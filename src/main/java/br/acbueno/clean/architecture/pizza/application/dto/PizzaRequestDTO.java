package br.acbueno.clean.architecture.pizza.application.dto;

import br.acbueno.clean.architecture.pizza.application.enums.SizePizza;
import lombok.Data;

@Data
public class PizzaRequestDTO {

  private String name;

  private double price;

  private SizePizza sizePizza;

}
