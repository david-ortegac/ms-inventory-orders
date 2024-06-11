package net.unir.ms_inventory_orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = { "net.unir.ms_inventory_orders.infraestructure.repositories" })
@EnableTransactionManagement
@EntityScan(basePackages = "net.unir.ms_inventory_orders.infraestructure.entities")
@SpringBootApplication
public class MsInventoryOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInventoryOrdersApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
