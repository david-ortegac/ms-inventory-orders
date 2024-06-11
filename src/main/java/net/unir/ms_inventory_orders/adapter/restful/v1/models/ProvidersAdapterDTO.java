package net.unir.ms_inventory_orders.adapter.restful.v1.models;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class ProvidersAdapterDTO {

    private Long id;

    @Valid
    private String name;

    @Valid
    private String lastName;

    @Valid
    private String address;

    @Valid
    private String phone;

    @Valid
    private String email;

}
