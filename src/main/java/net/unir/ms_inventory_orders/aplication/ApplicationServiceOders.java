package net.unir.ms_inventory_orders.aplication;


import net.unir.ms_inventory_orders.adapter.restful.v1.models.OrdersAdapterDTO;
import net.unir.ms_inventory_orders.domain.entities.OrdersDomainDTO;

import java.util.List;

public interface ApplicationServiceOders {
    OrdersDomainDTO getProvidersById(Long id);

    List<OrdersDomainDTO> getAll(Integer provider, Integer product, Integer amount);

    OrdersDomainDTO saveProvider(OrdersAdapterDTO adapterDTO) throws Exception;

    OrdersDomainDTO updateProvider(Long id, OrdersAdapterDTO adapterDTO);

    OrdersDomainDTO deleteProvider(Long id);

}
