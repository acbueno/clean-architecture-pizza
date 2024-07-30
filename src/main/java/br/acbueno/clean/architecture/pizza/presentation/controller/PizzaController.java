package br.acbueno.clean.architecture.pizza.presentation.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import br.acbueno.clean.architecture.pizza.application.dto.PizzaRequestDTO;
import br.acbueno.clean.architecture.pizza.application.service.PizzaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/pizza")
public class PizzaController {

  @Inject
  private PizzaService pizzaService;

  @POST
  public Response createPizza(@RequestBody PizzaRequestDTO request) {
    return Response.ok().entity(pizzaService.createPizza(request)).build();
  }

  @GET
  public Response findAllPizza() {
    return Response.ok().entity(pizzaService.findAllPizza()).build();
  }

  @GET
  @Path("/{id}")
  public Response findPizzaById(@PathParam("id") Long id) {
    return Response.ok().entity(pizzaService.findPizzaById(id)).build();
  }

  @DELETE
  @Path("/{id}")
  public Response deletePizzaById(@PathParam("id") Long id) {
    try {
      pizzaService.deletePizzaById(id);
      return Response.ok().build();
    } catch (Exception e) {
     return Response.serverError().build();
    }
  }

}
