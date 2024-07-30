package br.acbueno.clean.architecture.pizza.application.service;

import java.util.List;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaRequestDTO;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaResponseDTO;
import br.acbueno.clean.architecture.pizza.application.usecase.CreatePizzaUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.DeletePizzaUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.FindPizzaUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PizzaService {

  private final CreatePizzaUseCase createPizzaUseCase;

  private final FindPizzaUseCase findPizzaUseCase;

  private final DeletePizzaUseCase deletePizzaUseCase;

  @Inject
  public PizzaService(CreatePizzaUseCase createPizzaUseCase, FindPizzaUseCase findPizzaUseCase,
      DeletePizzaUseCase deletePizzaUseCase) {
    this.createPizzaUseCase = createPizzaUseCase;
    this.findPizzaUseCase = findPizzaUseCase;
    this.deletePizzaUseCase = deletePizzaUseCase;
  }

  @Transactional
  public PizzaResponseDTO createPizza(PizzaRequestDTO request) {
    return createPizzaUseCase.execute(request);
  }

  public List<PizzaResponseDTO> findAllPizza(){
    return findPizzaUseCase.execute();
  }

  public PizzaResponseDTO findPizzaById(Long id) {
    return findPizzaUseCase.execute(id);
  }

  @Transactional
  public void deletePizzaById(Long id) {
    deletePizzaUseCase.execute(id);
  }

}
