package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import org.modelmapper.ModelMapper;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.CreateCustomerUseCase;
import br.acbueno.clean.architecture.pizza.domain.model.Customer;
import br.acbueno.clean.architecture.pizza.domain.repository.CustomerRepository;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;

  public CreateCustomerUseCaseImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
    this.customerRepository = customerRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public CustomerResponseDTO execute(CustomerRequestDTO request) {
    Customer customer = modelMapper.map(request, Customer.class);
    Customer saveOrder = customerRepository.saveOrder(customer);
    return modelMapper.map(saveOrder, CustomerResponseDTO.class);
  }

}
