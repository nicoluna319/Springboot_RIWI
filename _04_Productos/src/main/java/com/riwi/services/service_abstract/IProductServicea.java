package com.riwi.services.service_abstract;

import java.util.List;

import com.riwi.entities.Product;

public interface IProductServicea {
            
            public Product save(Product product);
            public List<Product> getAll();
            public Product findById(Long id);
            public boolean delete(Long id);
            public Product update(Long id, Product product);
    
}
