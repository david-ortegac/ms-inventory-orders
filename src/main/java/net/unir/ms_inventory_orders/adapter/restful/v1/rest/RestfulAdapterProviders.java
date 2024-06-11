package net.unir.ms_inventory_orders.adapter.restful.v1.rest;

import jakarta.validation.Valid;
import net.unir.ms_inventory_orders.adapter.restful.v1.mappers.AdapterOdersMapper;
import net.unir.ms_inventory_orders.adapter.restful.v1.models.OrdersAdapterDTO;
import net.unir.ms_inventory_orders.aplication.ApplicationServiceOders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class RestfulAdapterProviders {

    @Autowired
    private AdapterOdersMapper mapper;

    @Autowired
    private ApplicationServiceOders serviceProviders;

    @GetMapping
    public ResponseEntity<List<OrdersAdapterDTO>> getAllProviders(@RequestParam(required = false) Integer provider, @RequestParam(required = false) Integer product, @RequestParam(required = false) Integer amount) {
        return new ResponseEntity<>(mapper.fromDomainToAdapterList(serviceProviders.getAll(provider, product, amount )), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersAdapterDTO> getProvidersById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.getProvidersById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrdersAdapterDTO> save(@Valid @RequestBody OrdersAdapterDTO adapterDTO) throws Exception {
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.saveProvider(adapterDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PatchMapping("/{id}")
    public ResponseEntity<OrdersAdapterDTO> update(@Valid @PathVariable Long id, @Valid @RequestBody OrdersAdapterDTO adapterDTO){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.updateProvider(id, adapterDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrdersAdapterDTO> delete(@Valid @PathVariable Long id){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.deleteProvider(id)), HttpStatus.OK);
    }
}
