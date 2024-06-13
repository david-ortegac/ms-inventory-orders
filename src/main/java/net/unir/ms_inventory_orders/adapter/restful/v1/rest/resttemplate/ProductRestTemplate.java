package net.unir.ms_inventory_orders.adapter.restful.v1.rest.resttemplate;

import net.unir.ms_inventory_orders.adapter.restful.v1.models.ProductsAdapterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductRestTemplate {
    @Autowired
    private RestTemplate restTemplate;

    public ProductsAdapterDTO getProductById(Long id) {
        ResponseEntity<ProductsAdapterDTO> product = restTemplate.getForEntity("http://localhost:8087/api/v1/products/" + id, ProductsAdapterDTO.class);
        return product.getBody();
    }
}
