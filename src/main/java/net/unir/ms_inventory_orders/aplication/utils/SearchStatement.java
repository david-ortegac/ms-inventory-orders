package net.unir.ms_inventory_orders.aplication.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchStatement {
    private String key;
    private Object value;
    private SearchOperation operation;
}
