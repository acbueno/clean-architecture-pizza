package br.acbueno.clean.architecture.pizza.domain.repository;

import java.util.List;

import br.acbueno.clean.architecture.pizza.domain.model.Order;

public interface OrderRepository {

  Order saveOrder(Order order);

  Order findOrderById(Long id);

  List<Order> findOrderAll();

  void deleteOrderById(Long id);

}
