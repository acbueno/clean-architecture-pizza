package br.acbueno.clean.architecture.pizza.domain.repository.impl;

import java.util.List;

import br.acbueno.clean.architecture.pizza.domain.model.Customer;
import br.acbueno.clean.architecture.pizza.domain.repository.CustomerRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepositoryImpl implements CustomerRepository, PanacheRepositoryBase<Customer, Long> {

  @Override
  public Customer findCustomerById(Long id) {
    return findById(id);
  }

  @Override
  public Customer saveOrder(Customer customer) {
    persist(customer);
    return customer;
  }

  @Override
  public List<Customer> findAllCustomer() {
    return listAll();
  }

  @Override
  public void deleteCustomerById(Long id) {
    deleteById(id);
  }

}
