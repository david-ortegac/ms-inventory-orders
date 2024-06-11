package net.unir.ms_inventory_orders.infraestructure;

import lombok.RequiredArgsConstructor;
import net.unir.ms_inventory_orders.aplication.utils.SearchCriteria;
import net.unir.ms_inventory_orders.aplication.utils.SearchOperation;
import net.unir.ms_inventory_orders.aplication.utils.SearchStatement;
import net.unir.ms_inventory_orders.domain.OdersRepositoryDomain;
import net.unir.ms_inventory_orders.domain.entities.OrdersDomainDTO;
import net.unir.ms_inventory_orders.infraestructure.entities.OrdersJPA;
import net.unir.ms_inventory_orders.infraestructure.mappers.InfraestructureMapper;
import net.unir.ms_inventory_orders.infraestructure.repositories.OrdersRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class OrdersRepositoryJPAImp implements OdersRepositoryDomain {

    private static final Pageable pageable = PageRequest.of(0, 10);

    @Autowired
    private OrdersRepositoryJPA repositoryJPA;

    @Autowired
    private InfraestructureMapper mapper;

    @Override
    public List<OrdersDomainDTO> getAll() {
        List<OrdersJPA> providersJPA = repositoryJPA.findAll();
        return mapper.toDomainList(providersJPA);
    }

    @Override
    public List<OrdersDomainDTO> search(Integer idProduct, Integer idProvider, Integer amount) {
        SearchCriteria<OrdersJPA> spec = new SearchCriteria<>();

        if (null!=idProvider) {
            spec.add(new SearchStatement("idProvider", idProvider, SearchOperation.MATCH));
        }
        if (null != idProduct) {
            spec.add(new SearchStatement("idProduct", idProduct, SearchOperation.EQUAL));
        }
        if (amount > 0) {
            spec.add(new SearchStatement("amount", amount, SearchOperation.EQUAL));
        }

        return mapper.toDomainList(repositoryJPA.findAll(spec));
    }

    @Override
    public OrdersDomainDTO getById(Long id) {
        Optional<OrdersJPA> getById = repositoryJPA.findById(id);
        return mapper.toDomain(getById.orElse(null));
    }

    @Override
    public OrdersDomainDTO save(OrdersDomainDTO domainDTO) {
        return mapper.toDomain(repositoryJPA.save(mapper.fromDomain(domainDTO)));
    }

    @Override
    public OrdersDomainDTO delete(Long id) {
        Optional<OrdersJPA> deleted = repositoryJPA.findById(id);
        repositoryJPA.deleteById(id);
        return mapper.toDomain(deleted.orElseThrow());
    }
}
