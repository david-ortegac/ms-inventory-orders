package net.unir.ms_inventory_orders.aplication;

import lombok.extern.slf4j.Slf4j;
import net.unir.ms_inventory_orders.adapter.restful.v1.mappers.AdapterOdersMapper;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.OrdersAdapterDTO;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProvidersAdapterDTO;
import net.unir.ms_inventory_orders.adapter.restful.v1.rest.resttemplate.ProductRestTemplate;
import net.unir.ms_inventory_orders.adapter.restful.v1.rest.resttemplate.ProvidersRestTemplate;
import net.unir.ms_inventory_orders.domain.OdersRepositoryDomain;
import net.unir.ms_inventory_orders.domain.entities.OrdersDomainDTO;
import net.unir.ms_inventory_orders.domain.entities.ProductsDomainDTO;
import net.unir.ms_inventory_orders.domain.entities.ProvidersDomainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
class ApplicationServiceOdersImp implements ApplicationServiceOders {

    @Autowired
    private OdersRepositoryDomain repositoryDomain;

    @Autowired
    private ProductRestTemplate productRestTemplate;

    @Autowired
    private ProvidersRestTemplate providerRestTemplate;

    @Autowired
    private AdapterOdersMapper mapper;

    private ProductsDomainDTO getProductById(Long id) {
        ProductsAdapterDTO res = this.productRestTemplate.getProductById(id);
        return mapper.productFromAdapterToDomain(res);
    }

    private ProvidersDomainDTO getProviderById(Long id) {
        ProvidersAdapterDTO res = this.providerRestTemplate.getProviderById(id);
        return mapper.providerFromAdapterToDomain(res);
    }

    @Override
    public List<OrdersDomainDTO> getAll(Integer provider, Integer product, Integer amount) {
        if ((null != product && product > 0)
                || (null != provider && provider > 0)
                || (null != amount && amount > 0)) {
            List<OrdersDomainDTO> orders = repositoryDomain.search(product, provider, amount);
            orders.forEach(res -> {
                ProductsDomainDTO productById = this.getProductById(res.getProduct().id);
                ProvidersDomainDTO providerById = this.getProviderById(res.getProvider().id);
                res.setProduct(productById);
                res.setProvider(providerById);
            });
            return mapper.fromAdapterToDomainList(mapper.fromDomainToAdapterList(orders));
        }

        List<OrdersDomainDTO> orders = repositoryDomain.getAll();

        orders.forEach(res -> {
            ProductsDomainDTO productById = this.getProductById(res.getProduct().id);
            ProvidersDomainDTO providerById = this.getProviderById(res.getProvider().id);
            res.setProduct(productById);
            res.setProvider(providerById);
        });

        return mapper.fromAdapterToDomainList(mapper.fromDomainToAdapterList(orders));
    }

    @Override
    public OrdersDomainDTO getProvidersById(Long id) {
        OrdersDomainDTO res = repositoryDomain.getById(id);
        ProductsDomainDTO product = this.getProductById(res.getProduct().id);
        ProvidersDomainDTO provider = this.getProviderById(res.getProvider().id);
        res.setProduct(product);
        res.setProvider(provider);
        return res;
    }

    @Override
    public OrdersDomainDTO saveProvider(OrdersAdapterDTO adapterDTO) throws Exception {
        if (null != adapterDTO.getProduct().getId() && null != adapterDTO.getProvider().getId() && adapterDTO.getAmount() > 0) {
            OrdersDomainDTO res = repositoryDomain.save(mapper.fromAdapterToDomain(adapterDTO));
            ProductsDomainDTO productById = this.getProductById(res.getProduct().id);
            ProvidersDomainDTO providerById = this.getProviderById(res.getProvider().id);
            res.setProduct(productById);
            res.setProvider(providerById);
            return res;
        } else {
            throw new Exception("Error al guardar el producto");
        }
    }

    @Override
    public OrdersDomainDTO updateProvider(Long id, OrdersAdapterDTO adapterDTO) {
        OrdersDomainDTO order = this.getProvidersById(id);
        adapterDTO.setId(id);
        if (null != adapterDTO.getProvider()) {
            if (null != adapterDTO.getProvider().getId()) {
                ProvidersDomainDTO provider = new ProvidersDomainDTO();
                provider.setId(adapterDTO.getProvider().getId());
                order.setProvider(provider);
            }
        }
        if (null != adapterDTO.getProduct()) {
            if (null != adapterDTO.getProduct().getId()) {
                ProductsDomainDTO product = new ProductsDomainDTO();
                product.setId(adapterDTO.getProduct().getId());
                order.setProduct(product);
            }
        }
        if (null != adapterDTO.getAmount()) {
            order.setAmount(adapterDTO.getAmount());
        }
        OrdersDomainDTO res = repositoryDomain.save(mapper.fromAdapterToDomain(mapper.fromDomainToAdapter(order)));
        ProductsDomainDTO productById = this.getProductById(res.getProduct().id);
        ProvidersDomainDTO providerById = this.getProviderById(res.getProvider().id);
        res.setProduct(productById);
        res.setProvider(providerById);

        return res;
    }

    @Override
    public OrdersDomainDTO deleteProvider(Long id) {
        OrdersDomainDTO res = repositoryDomain.delete(id);
        ProductsDomainDTO productById = this.getProductById(res.getProduct().id);
        ProvidersDomainDTO providerById = this.getProviderById(res.getProvider().id);
        res.setProduct(productById);
        res.setProvider(providerById);

        return res;
    }
}
