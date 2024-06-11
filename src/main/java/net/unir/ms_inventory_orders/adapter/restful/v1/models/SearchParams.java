package net.unir.ms_inventory_orders.adapter.restful.v1.models;

import lombok.Getter;

@Getter
public class SearchParams {
    private Integer provider;
    private Integer product;
    private Integer amount;
}
