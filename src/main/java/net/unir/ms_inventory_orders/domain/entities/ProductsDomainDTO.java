package net.unir.ms_inventory_orders.domain.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDomainDTO {
    public Long id;
    private String name;
    private String category;
    private String manufacturer;
    private int guarantyMonths;
    private int price;
}
