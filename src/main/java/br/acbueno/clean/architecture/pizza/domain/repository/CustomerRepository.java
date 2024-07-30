package br.acbueno.clean.architecture.pizza.domain.repository;

import java.util.List;

import br.acbueno.clean.architecture.pizza.domain.model.Customer;

public interface CustomerRepository {

  Customer findCustomerById(Long id);

  Customer saveOrder(Customer customer);

  List<Customer> findAllCustomer();

  void deleteCustomerById(Long id);

}
