package br.acbueno.clean.architecture.pizza.domain.model;

import br.acbueno.clean.architecture.pizza.application.enums.SizePizza;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pizza")
@Data
public class Pizza {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private SizePizza sizePizza;

  private double price;

}
