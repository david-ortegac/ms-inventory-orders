package net.unir.ms_inventory_orders.adapter.restful.v1.models;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class OrdersAdapterDTO {

    private Long id;
    private ProductsAdapterDTO product;
    private ProvidersAdapterDTO provider;
    private Integer amount;

}
