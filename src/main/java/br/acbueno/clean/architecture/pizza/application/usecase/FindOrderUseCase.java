package br.acbueno.clean.architecture.pizza.application.usecase;

import java.util.List;

import br.acbueno.clean.architecture.pizza.application.dto.OrderResponseDTO;

public interface FindOrderUseCase {

  OrderResponseDTO execute(Long id);

  List<OrderResponseDTO> execute();

}
