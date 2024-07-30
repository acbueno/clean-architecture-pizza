package br.acbueno.clean.architecture.pizza.application.service;

import java.util.List;

import br.acbueno.clean.architecture.pizza.application.dto.OrderRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.OrderResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.CreateOrderUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.DeleteOrderUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.FindOrderUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderService {

  private final CreateOrderUseCase createOrderUseCase;
  private final FindOrderUseCase findOrderUseCase;
  private final DeleteOrderUseCase deleteOrderUseCase;

  @Inject
  public OrderService(CreateOrderUseCase createOrderUseCase, FindOrderUseCase findOrderUseCase,
      DeleteOrderUseCase deleteOrderUseCase) {
    this.createOrderUseCase = createOrderUseCase;
    this.findOrderUseCase = findOrderUseCase;
    this.deleteOrderUseCase = deleteOrderUseCase;
  }

  @Transactional
  public OrderResponseDTO createOrder(OrderRequestDTO request) {
    return createOrderUseCase.execute(request);
  }

  public OrderResponseDTO findOrderById(Long id) {
    return findOrderUseCase.execute(id);
  }

  public List<OrderResponseDTO> findOrderAll(){
    return findOrderUseCase.execute();
  }

  @Transactional
  public void deleteOrderById(Long id) {
    deleteOrderUseCase.execute(id);
  }

}
