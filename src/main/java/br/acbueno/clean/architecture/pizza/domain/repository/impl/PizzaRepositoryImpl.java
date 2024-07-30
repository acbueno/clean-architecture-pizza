package br.acbueno.clean.architecture.pizza.domain.repository.impl;

import java.util.List;
import br.acbueno.clean.architecture.pizza.domain.model.Pizza;
import br.acbueno.clean.architecture.pizza.domain.repository.PizzaRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PizzaRepositoryImpl implements PizzaRepository, PanacheRepositoryBase<Pizza, Long> {

  @Override
  public Pizza findByPizzaById(Long id) {
    return findById(id);
  }

  @Override
  public List<Pizza> findAllPizza() {
    return listAll();
  }

  @Override
  public Pizza save(Pizza pizza) {
    persist(pizza);
    return pizza;
  }

  @Override
  public void deletePizza(Long id) {
    deleteById(id);
  }

}
