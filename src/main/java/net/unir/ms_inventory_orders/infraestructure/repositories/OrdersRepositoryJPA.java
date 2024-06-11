package net.unir.ms_inventory_orders.infraestructure.repositories;

import net.unir.ms_inventory_orders.infraestructure.entities.OrdersJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrdersRepositoryJPA extends JpaRepository<OrdersJPA, Long>, JpaSpecificationExecutor<OrdersJPA> {
}
