package guru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {
	
	private final RestTemplate restTemplate;
	
	private String apihost;
	private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public CustomerDto getCustomerById(UUID uuid) {
		return restTemplate.getForObject(apihost+CUSTOMER_PATH_V1+uuid.toString(), CustomerDto.class);
	}
	
	public URI createCustomer(CustomerDto customerDto) {
		return restTemplate.postForLocation(apihost+CUSTOMER_PATH_V1, customerDto);
	}
	
	public void updateCustomer(UUID id, CustomerDto customerDto) {
		restTemplate.put(apihost+CUSTOMER_PATH_V1+id.toString(), customerDto);
	}
	
	public void deleteCustomer(UUID id) {
		restTemplate.delete(apihost+CUSTOMER_PATH_V1+id);
	}

	public void setApihost(String apihost) {
		this.apihost = apihost;
	}

	
}
