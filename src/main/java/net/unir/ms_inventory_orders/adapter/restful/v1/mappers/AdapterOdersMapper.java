package net.unir.ms_inventory_orders.adapter.restful.v1.mappers;

import net.unir.ms_inventory_orders.adapter.restful.v1.models.OrdersAdapterDTO;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProvidersAdapterDTO;
import net.unir.ms_inventory_orders.domain.entities.OrdersDomainDTO;
import net.unir.ms_inventory_orders.domain.entities.ProductsDomainDTO;
import net.unir.ms_inventory_orders.domain.entities.ProvidersDomainDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdapterOdersMapper {
    OrdersAdapterDTO fromDomainToAdapter(OrdersDomainDTO domainDTO);
    OrdersDomainDTO fromAdapterToDomain(OrdersAdapterDTO adapterDTO);

    List<OrdersAdapterDTO> fromDomainToAdapterList(List<OrdersDomainDTO> providerDomainDTOList);

    List<OrdersDomainDTO> fromAdapterToDomainList(List<OrdersAdapterDTO> adapterDTOList);

    ProductsAdapterDTO productFromDomainToAdapter(ProductsDomainDTO domainDTO);
    ProductsDomainDTO productFromAdapterToDomain(ProductsAdapterDTO adapterDTO);

    ProvidersAdapterDTO providerFromDomainToAdapter(ProvidersDomainDTO domainDTO);
    ProvidersDomainDTO providerFromAdapterToDomain(ProvidersAdapterDTO adapterDTO);
}
