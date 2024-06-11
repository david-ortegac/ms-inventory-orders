package net.unir.ms_inventory_orders.domain.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvidersDomainDTO {
    public Long id;

    @Valid
    @NotNull
    public String name;

    @Valid
    @NotNull
    public String lastName;

    @Valid
    @NotNull
    public String address;

    @Valid
    @NotNull
    public String phone;

    @Valid
    @NotNull
    public String email;

}
