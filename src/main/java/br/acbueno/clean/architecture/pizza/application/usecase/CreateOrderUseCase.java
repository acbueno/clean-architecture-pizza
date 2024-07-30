package br.acbueno.clean.architecture.pizza.application.usecase;

import br.acbueno.clean.architecture.pizza.application.dto.OrderRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.OrderResponseDTO;

public interface CreateOrderUseCase {

  public OrderResponseDTO execute(OrderRequestDTO request);

}
