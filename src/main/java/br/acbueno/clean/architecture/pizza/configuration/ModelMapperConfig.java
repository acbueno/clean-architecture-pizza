package br.acbueno.clean.architecture.pizza.configuration;

import org.modelmapper.ModelMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ModelMapperConfig {

  @Produces
  @ApplicationScoped
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
