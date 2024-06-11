package net.unir.ms_inventory_orders.domain.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersDomainDTO {
    public Long id;

    @Valid
    @NotNull
    public ProductsDomainDTO product;

    @Valid
    @NotNull
    public ProvidersDomainDTO provider;

    @Valid
    @NotNull
    public Integer amount;
}
