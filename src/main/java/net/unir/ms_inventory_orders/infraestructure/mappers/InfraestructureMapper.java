package net.unir.ms_inventory_orders.infraestructure.mappers;

import net.unir.ms_inventory_orders.domain.entities.OrdersDomainDTO;
import net.unir.ms_inventory_orders.infraestructure.entities.OrdersJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfraestructureMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "product.id", source = "idProduct"),
            @Mapping(target = "provider.id", source = "idProvider"),
            @Mapping(target = "amount", source = "amount"),
    })
    OrdersDomainDTO toDomain(OrdersJPA item);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "product.id", source = "idProduct"),
            @Mapping(target = "provider.id", source = "idProvider"),
            @Mapping(target = "amount", source = "amount"),
    })
    List<OrdersDomainDTO> toDomainList(Iterable<OrdersJPA> items);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "product.id", target = "idProduct"),
            @Mapping(source = "provider.id", target = "idProvider"),
            @Mapping(source = "amount", target = "amount"),
    })
    OrdersJPA fromDomain(OrdersDomainDTO item);
}
