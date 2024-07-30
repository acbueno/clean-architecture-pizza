package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import br.acbueno.clean.architecture.pizza.application.usecase.DeleteOrderUseCase;
import br.acbueno.clean.architecture.pizza.domain.repository.OrderRepository;

public class DeleteOrderUseCaseImpl implements DeleteOrderUseCase {

  private OrderRepository orderRepository;

  public DeleteOrderUseCaseImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public void execute(Long id) {
    orderRepository.deleteOrderById(id);
  }

}
