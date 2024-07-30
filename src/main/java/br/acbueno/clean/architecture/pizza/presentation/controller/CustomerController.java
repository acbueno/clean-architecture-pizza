package br.acbueno.clean.architecture.pizza.presentation.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import br.acbueno.clean.architecture.pizza.application.dto.CustomerRequestDTO;
import br.acbueno.clean.architecture.pizza.application.service.CustomerService;
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

@Path("/api/customer")
public class CustomerController {

  @Inject
  CustomerService customerService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response create(@RequestBody CustomerRequestDTO request) {
    return Response.ok().entity(customerService.create(request)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAll() {
    try {
      return Response.ok().entity(customerService.findAllCustomer()).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findById(@PathParam("id") Long id) {
    try {
      return Response.ok().entity(customerService.findCustomerById(id)).build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

  @DELETE
  public Response deleteCustomerById(Long id) {
    try {
      customerService.deleteCustomerById(id);
      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError().build();
    }
  }

}
