package net.unir.ms_inventory_orders.infraestructure.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "orders")
public class OrdersJPA implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "id_provider")
    private Long idProvider;

    @Column(name = "amount")
    private Integer amount;

}
