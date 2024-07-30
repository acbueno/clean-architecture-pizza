package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import br.acbueno.clean.architecture.pizza.application.usecase.DeletePizzaUseCase;
import br.acbueno.clean.architecture.pizza.domain.repository.PizzaRepository;

public class DeletePizzaUseCaseImpl implements DeletePizzaUseCase {

  private PizzaRepository pizzaRepository;

  public DeletePizzaUseCaseImpl(PizzaRepository pizzaRepository) {
    this.pizzaRepository = pizzaRepository;
  }

  @Override
  public void execute(Long id) {
    pizzaRepository.deletePizza(id);
  }

}
