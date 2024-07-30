package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.acbueno.clean.architecture.pizza.application.dto.OrderRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.OrderResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.CreateOrderUseCase;
import br.acbueno.clean.architecture.pizza.domain.model.Order;
import br.acbueno.clean.architecture.pizza.domain.model.OrderItem;
import br.acbueno.clean.architecture.pizza.domain.model.Pizza;
import br.acbueno.clean.architecture.pizza.domain.repository.CustomerRepository;
import br.acbueno.clean.architecture.pizza.domain.repository.OrderRepository;
import br.acbueno.clean.architecture.pizza.domain.repository.PizzaRepository;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

  private OrderRepository orderRepository;
  private CustomerRepository customerRepository;
  private PizzaRepository pizzaRepository;
  private ModelMapper modelMapper;

  public CreateOrderUseCaseImpl(OrderRepository orderRepository, CustomerRepository customerRepository, PizzaRepository pizzaRepository, ModelMapper modelMapper) {
    this.orderRepository = orderRepository;
    this.customerRepository = customerRepository;
    this.pizzaRepository = pizzaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public OrderResponseDTO execute(OrderRequestDTO orderRequest) {
    Order order = new Order();
    List<OrderItem> items = orderRequest.getItems().stream()
        .map(itemDTO -> {
          OrderItem item = new OrderItem();
          item.setQuantity(itemDTO.getQuantity());
          Pizza pizza = pizzaRepository.findByPizzaById(itemDTO.getPizzaId());
          item.setPizza(pizza);

          return item;
        }).collect(Collectors.toList());

    order.setItems(items);
    order.setCustomer(customerRepository.findCustomerById(orderRequest.getCustomerId()));
    double total = items.stream()
        .mapToDouble(item -> item.getPizza().getPrice() * item.getQuantity())
        .sum();
    order.setTotal(total);
    Order saveorder = orderRepository.saveOrder(order);

    return modelMapper.map(saveorder, OrderResponseDTO.class);
  }

}
