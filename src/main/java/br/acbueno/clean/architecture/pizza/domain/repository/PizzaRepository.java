package br.acbueno.clean.architecture.pizza.domain.repository;

import java.util.List;

import br.acbueno.clean.architecture.pizza.domain.model.Pizza;

public interface PizzaRepository {

  Pizza findByPizzaById(Long id);

  List<Pizza> findAllPizza();

  Pizza save(Pizza pizza);

  void deletePizza(Long id);

}
