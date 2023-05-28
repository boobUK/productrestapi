package com.springlearn.productrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.productrestapi.models.Product;
import com.springlearn.productrestapi.repositories.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository repository;

	@PostMapping("products")
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@GetMapping("products")
	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		return repository.findAll();
	}

	@GetMapping("products/{id}")
	@Transactional(readOnly = true)
	@Cacheable("product-cashe")
	public Product getProduct(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@PutMapping("products")
	public Product updateProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@DeleteMapping("products/{id}")
	@CacheEvict("product-cashe")
	public void deleteProduct(@PathVariable("id") int id) {
		 repository.deleteById(id);
	}
	
}
