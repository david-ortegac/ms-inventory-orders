package net.unir.ms_inventory_orders.domain;

import net.unir.ms_inventory_orders.domain.entities.OrdersDomainDTO;

import java.util.List;

public interface OdersRepositoryDomain {

    List<OrdersDomainDTO> getAll();

    List<OrdersDomainDTO> search(Integer idProduct, Integer idProvider, Integer amount);

    OrdersDomainDTO getById(Long id);

    OrdersDomainDTO save(OrdersDomainDTO domainDTO);

    OrdersDomainDTO delete(Long id);
}
