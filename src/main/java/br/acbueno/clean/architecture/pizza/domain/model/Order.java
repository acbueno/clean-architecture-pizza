package br.acbueno.clean.architecture.pizza.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_customer")
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Customer customer;

  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderItem> items;

  private double total;

  public void calculateTotal() {
    this.total = items.stream()
        .mapToDouble(item -> item.getPizza().getPrice() * item.getQuantity())
        .sum();
  }

}
