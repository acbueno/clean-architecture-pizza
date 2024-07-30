package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import org.modelmapper.ModelMapper;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.CreatePizzaUseCase;
import br.acbueno.clean.architecture.pizza.domain.model.Pizza;
import br.acbueno.clean.architecture.pizza.domain.repository.PizzaRepository;

public class CreatePizzaUseCaseImpl implements CreatePizzaUseCase {

  private final ModelMapper modelMapper;
  private PizzaRepository pizzaRepository;

  public CreatePizzaUseCaseImpl(PizzaRepository pizzaRepository, ModelMapper modelMapper) {
    this.pizzaRepository = pizzaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public PizzaResponseDTO execute(PizzaRequestDTO dto) {
    Pizza pizza = modelMapper.map(dto, Pizza.class);
    Pizza pizzaSaved = pizzaRepository.save(pizza);
    return modelMapper.map(pizzaSaved, PizzaResponseDTO.class);
  }

}
