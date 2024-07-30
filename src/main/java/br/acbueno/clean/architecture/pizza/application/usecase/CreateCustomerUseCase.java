package br.acbueno.clean.architecture.pizza.application.usecase;

import br.acbueno.clean.architecture.pizza.application.dto.CustomerRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerResponseDTO;

public interface CreateCustomerUseCase {

  CustomerResponseDTO execute(CustomerRequestDTO request);

}
