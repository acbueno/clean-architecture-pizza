package br.acbueno.clean.architecture.pizza.domain.repository.impl;

import java.util.List;

import br.acbueno.clean.architecture.pizza.domain.model.Order;
import br.acbueno.clean.architecture.pizza.domain.repository.OrderRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRespositoryImpl implements OrderRepository, PanacheRepositoryBase<Order, Long> {

  @Override
  public Order saveOrder(Order order) {
    persist(order);
    return order;
  }

  @Override
  public Order findOrderById(Long id) {
    return findById(id);
  }

  @Override
  public List<Order> findOrderAll() {
    return listAll();
  }

  @Override
  public void deleteOrderById(Long id) {
    deleteById(id);
  }

}
