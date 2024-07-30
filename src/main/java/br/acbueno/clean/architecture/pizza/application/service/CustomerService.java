package br.acbueno.clean.architecture.pizza.application.service;

import java.util.List;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.CreateCustomerUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.DeleteCustomerUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.FindCustomerUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService {

  private final CreateCustomerUseCase createCustomerUseCase;
  private final FindCustomerUseCase findCustomerUseCase;
  private final DeleteCustomerUseCase deleteCustomerUseCase;

  @Inject
  public CustomerService(CreateCustomerUseCase createCustomerUseCase, FindCustomerUseCase findCustomerUseCase
      , DeleteCustomerUseCase deleteCustomerUseCase) {
    this.createCustomerUseCase = createCustomerUseCase;
    this.findCustomerUseCase = findCustomerUseCase;
    this.deleteCustomerUseCase = deleteCustomerUseCase;
  }

  @Transactional
  public CustomerResponseDTO create(CustomerRequestDTO request) {
    return createCustomerUseCase.execute(request);
  }

  public List<CustomerResponseDTO> findAllCustomer() {
    return findCustomerUseCase.execute();
  }

  public CustomerResponseDTO findCustomerById(Long id) {
    return findCustomerUseCase.execute(id);
  }

  public void deleteCustomerById(Long id) {
    deleteCustomerUseCase.execute(id);
  }

}
