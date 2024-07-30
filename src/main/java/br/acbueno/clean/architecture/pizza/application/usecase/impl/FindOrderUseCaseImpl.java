package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import br.acbueno.clean.architecture.pizza.application.dto.OrderResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.FindOrderUseCase;
import br.acbueno.clean.architecture.pizza.domain.model.Order;
import br.acbueno.clean.architecture.pizza.domain.repository.OrderRepository;

public class FindOrderUseCaseImpl implements FindOrderUseCase {

  private final OrderRepository orderRepository;
  private final ModelMapper modelMapper;

  public FindOrderUseCaseImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
    this.orderRepository = orderRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public OrderResponseDTO execute(Long id) {
    return modelMapper.map(orderRepository.findOrderById(id), OrderResponseDTO.class);
  }

  @Override
  public List<OrderResponseDTO> execute() {
    List<OrderResponseDTO> listOrderResponse = new ArrayList<>();
    List<Order> listOrder = orderRepository.findOrderAll();

    for (Order order : listOrder) {
      OrderResponseDTO orderResponse = modelMapper.map(order, OrderResponseDTO.class);
       listOrderResponse.add(orderResponse);
    }
    return listOrderResponse;
  }

}
