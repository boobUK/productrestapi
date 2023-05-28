package com.springlearn.productrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.springlearn.productrestapi.models.Product;

//@ExtendWith(ProductrestapiApplication.class)
@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseUrl;
	
	@Test
	void testGetProduct() {
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl + 2, Product.class);
		assertNotNull(product);
		assertEquals("Apple", product.getName());
	}

}
