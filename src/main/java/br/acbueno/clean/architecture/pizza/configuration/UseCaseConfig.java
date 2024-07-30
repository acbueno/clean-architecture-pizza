package br.acbueno.clean.architecture.pizza.configuration;

import org.modelmapper.ModelMapper;
import br.acbueno.clean.architecture.pizza.application.usecase.CreateCustomerUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.CreateOrderUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.CreatePizzaUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.DeleteCustomerUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.DeleteOrderUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.DeletePizzaUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.FindCustomerUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.FindOrderUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.FindPizzaUseCase;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.CreateCustomerUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.CreateOrderUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.CreatePizzaUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.DeleteCustomerUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.DeleteOrderUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.DeletePizzaUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.FindCustomerUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.FindOrderUseCaseImpl;
import br.acbueno.clean.architecture.pizza.application.usecase.impl.FindPizzaUseCaseImpl;
import br.acbueno.clean.architecture.pizza.domain.repository.CustomerRepository;
import br.acbueno.clean.architecture.pizza.domain.repository.OrderRepository;
import br.acbueno.clean.architecture.pizza.domain.repository.PizzaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class UseCaseConfig {

  @Produces
  public CreatePizzaUseCase createPizzaUseCase(PizzaRepository pizzaRepository, ModelMapper modelMapper) {
    return new CreatePizzaUseCaseImpl(pizzaRepository, modelMapper);
  }

  @Produces
  public CreateCustomerUseCase createCustomerUseCase(CustomerRepository customerRepository, ModelMapper modelMapper) {
    return new CreateCustomerUseCaseImpl(customerRepository, modelMapper);
  }

  @Produces
  public CreateOrderUseCase createOrderUseCase(OrderRepository orderRepository, CustomerRepository customerRepository, PizzaRepository pizzaRepository, ModelMapper modelMapper) {
    return new CreateOrderUseCaseImpl(orderRepository, customerRepository, pizzaRepository, modelMapper);
  }

  @Produces
  public FindPizzaUseCase findPizzaUseCase(PizzaRepository pizzaRepository, ModelMapper modelMapper) {
    return new FindPizzaUseCaseImpl(pizzaRepository, modelMapper);
  }

  @Produces
  public DeletePizzaUseCase deletePizzaUseCase(PizzaRepository pizzaRepository) {
    return new DeletePizzaUseCaseImpl(pizzaRepository);
  }

  @Produces
  public FindCustomerUseCase findCustomerUseCase(CustomerRepository customerRepository, ModelMapper modelMapper) {
    return new FindCustomerUseCaseImpl(customerRepository, modelMapper);
  }

  @Produces
  public DeleteCustomerUseCase deleteCustomerUseCase(CustomerRepository customerRepository) {
    return new DeleteCustomerUseCaseImpl(customerRepository);
  }

  @Produces
  public FindOrderUseCase findOrderUseCase(OrderRepository orderRepository, ModelMapper modelMapper) {
    return new FindOrderUseCaseImpl(orderRepository, modelMapper);
  }

  @Produces
  public DeleteOrderUseCase deleteOrderUseCase(OrderRepository orderRepository) {
    return new DeleteOrderUseCaseImpl(orderRepository);
  }

}
