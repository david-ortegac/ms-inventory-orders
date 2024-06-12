package net.unir.ms_inventory_orders.adapter.restful.v1.models;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ProductsAdapterDTO {

    private Long id;

    private String name;
    private String category;
    private String manufacturer;
    private int guarantyMonths;
    private int price;

}
