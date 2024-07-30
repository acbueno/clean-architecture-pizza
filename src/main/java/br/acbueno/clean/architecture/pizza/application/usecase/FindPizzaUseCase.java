package br.acbueno.clean.architecture.pizza.application.usecase;

import java.util.List;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaResponseDTO;

public interface FindPizzaUseCase {

  List<PizzaResponseDTO> execute();

  PizzaResponseDTO execute(Long id);

}
