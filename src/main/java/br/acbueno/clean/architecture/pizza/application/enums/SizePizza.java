package br.acbueno.clean.architecture.pizza.application.enums;

import lombok.Getter;

@Getter
public enum SizePizza {
  FAMILY(1, "family"),
  MEDIUM(2, "medium"),
  SMALL(3, "small");

  private int code;
  private String description;

  private SizePizza(int code, String description) {
    this.code = code;
    this.description = description;
  }

}
