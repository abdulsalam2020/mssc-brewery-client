package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
	}
	
	@Test
	void createNewBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("Laila").build();
		URI location = client.createNewBeer(beerDto);
		System.out.println(location.toString());
		
	}
	
	@Test
	void updateBeer() {
		BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).build();
		client.updateBeer(beerDto.getId(), beerDto);
		
	}
	
	@Test
	void deleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}

}
