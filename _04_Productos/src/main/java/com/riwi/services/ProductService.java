package com.riwi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.entities.Product;
import com.riwi.repositories.ProductRepository;
import com.riwi.services.service_abstract.IProductServicea;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class ProductService implements IProductServicea {
	@Autowired
    private final ProductRepository productRepository;

	@Override
	public void delete(Long id) {

		Product productFind this.productRepository.findById(id).orElseThrow();;
	}

	@Override
	public Product findById(Long id) {

		return this.productRepository.findById(id).orElseThrow();
	}

	@Override
	public List<Product> getAll() {

		return this.productRepository.findAll();
	}

	@Override
	public Product save(Product product) {

		return this.productRepository.save(product);
	}

	@Override
	public Product update(Long id, Product objProduct) {

		this.productRepository.findById(id).orElseThrow();
		objProduct.setId(id);
		return this.productRepository.save(objProduct);
	}


    
}
