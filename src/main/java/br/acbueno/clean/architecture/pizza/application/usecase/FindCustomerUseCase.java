package br.acbueno.clean.architecture.pizza.application.usecase;

import java.util.List;

import br.acbueno.clean.architecture.pizza.application.dto.CustomerRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerResponseDTO;

public interface FindCustomerUseCase {

  CustomerResponseDTO execute(Long id);

  List<CustomerResponseDTO> execute();

}
