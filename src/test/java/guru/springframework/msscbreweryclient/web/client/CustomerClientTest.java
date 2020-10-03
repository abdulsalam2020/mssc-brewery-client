package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
public class CustomerClientTest {
	
	@Autowired
	CustomerClient client;
	
	@Test
	public void getCustomerById() {
		CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
		assertNotNull(customerDto);
	}
	
	@Test
	public void createCustomer() {
		CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
		URI location = client.createCustomer(customerDto);
		System.out.println(location.toString());
	}
	
	@Test
	public void updateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
		client.updateCustomer(customerDto.getId(), customerDto);
	}
	
	@Test
	public void deleteCustmer() {
		client.deleteCustomer(UUID.randomUUID());
	}

}
