package br.acbueno.clean.architecture.pizza.application.usecase;

import br.acbueno.clean.architecture.pizza.application.dto.PizzaRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaResponseDTO;

public interface CreatePizzaUseCase {

  PizzaResponseDTO execute(PizzaRequestDTO dto);

}
