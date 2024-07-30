package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import br.acbueno.clean.architecture.pizza.application.usecase.DeleteCustomerUseCase;
import br.acbueno.clean.architecture.pizza.domain.repository.CustomerRepository;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

  private CustomerRepository customerRepository;

  public DeleteCustomerUseCaseImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void execute(Long id) {
    customerRepository.deleteCustomerById(id);
  }

}
