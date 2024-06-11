package net.unir.ms_inventory_orders.adapter.restful.v1.models;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ProductsAdapterDTO {

    private Long id;

    @Valid
    private String name;

    @Valid
    private String description;

    @Valid
    private Double price;

    @Valid
    private Integer amount;

}
