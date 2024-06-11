package net.unir.ms_inventory_orders.adapter.restful.v1.rest.resttemplate;

import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProductsAdapterDTO;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProvidersAdapterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProvidersRestTemplate {
    @Autowired
    private RestTemplate restTemplate;

    public ProvidersAdapterDTO getProviderById(Long id){
        ResponseEntity<ProvidersAdapterDTO> product = restTemplate.getForEntity("http://localhost:8088/api/v1/proveedores/"+id, ProvidersAdapterDTO.class);
        return product.getBody();
    }
}
