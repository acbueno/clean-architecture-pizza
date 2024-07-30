package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.FindCustomerUseCase;
import br.acbueno.clean.architecture.pizza.domain.model.Customer;
import br.acbueno.clean.architecture.pizza.domain.repository.CustomerRepository;

public class FindCustomerUseCaseImpl implements FindCustomerUseCase {

  private CustomerRepository customerRepository;
  private final ModelMapper modelMapper;

  public FindCustomerUseCaseImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
    this.customerRepository = customerRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public CustomerResponseDTO execute(Long id) {
    return modelMapper.map(customerRepository.findCustomerById(id), CustomerResponseDTO.class);
  }

  @Override
  public List<CustomerResponseDTO> execute() {
    List<CustomerResponseDTO> listResponseDTOs = new ArrayList<>();
    List<Customer> listCustonerEtity = customerRepository.findAllCustomer();

    for (Customer customer : listCustonerEtity) {
        listResponseDTOs.add(modelMapper.map(customer, CustomerResponseDTO.class));
    }

    return listResponseDTOs;
  }

}
