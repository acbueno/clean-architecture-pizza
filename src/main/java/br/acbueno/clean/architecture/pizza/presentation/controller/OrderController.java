package br.acbueno.clean.architecture.pizza.presentation.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import br.acbueno.clean.architecture.pizza.application.dto.OrderRequestDTO;
import br.acbueno.clean.architecture.pizza.application.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/order")
public class OrderController {

  @Inject
  private OrderService orderService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response create(@RequestBody OrderRequestDTO request) {
    try {
      return Response.ok().entity(orderService.createOrder(request)).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findOrderById(@PathParam("id") Long id) {
    try {
      return Response.ok().entity(orderService.findOrderById(id)).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findOrderAll() {
    try {
      return Response.ok().entity(orderService.findOrderAll()).build();
    } catch (Exception e) {
       return Response.serverError().build();
    }
  }

  @DELETE
  @Path("/{id}")
  public void deleteOrderById(Long id) {
    orderService.deleteOrderById(id);
  }

}
