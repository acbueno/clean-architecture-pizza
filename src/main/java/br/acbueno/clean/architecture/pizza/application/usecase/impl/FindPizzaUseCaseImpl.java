package br.acbueno.clean.architecture.pizza.application.usecase.impl;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.FindPizzaUseCase;
import br.acbueno.clean.architecture.pizza.domain.model.Pizza;
import br.acbueno.clean.architecture.pizza.domain.repository.PizzaRepository;

public class FindPizzaUseCaseImpl implements FindPizzaUseCase {

  private final PizzaRepository pizzaRepository;
  private final ModelMapper modelMapper;

  public FindPizzaUseCaseImpl(PizzaRepository pizzaRepository, ModelMapper modelMapper) {
    this.pizzaRepository = pizzaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<PizzaResponseDTO> execute() {
    List<PizzaResponseDTO> listPizzaResponseDTO = new ArrayList<>();
    List<Pizza> listPizza = pizzaRepository.findAllPizza();

    for (Pizza pizza : listPizza) {
      listPizzaResponseDTO.add(modelMapper.map(pizza, PizzaResponseDTO.class));
    }

    return listPizzaResponseDTO;
  }

  @Override
  public PizzaResponseDTO execute(Long id) {
    return modelMapper.map(pizzaRepository.findByPizzaById(id), PizzaResponseDTO.class);
  }

}
