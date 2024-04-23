package com.riwi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.entities.Product;
import com.riwi.services.service_abstract.IProductServicea;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final IProductServicea productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.findById(id));
    }

@PostMapping
public ResponseEntity<Product> insert(@RequestBody Product objProduct){
    return ResponseEntity.ok(this.productService.save(objProduct));
}

@PutMapping (path = "/{id}")
public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product){
    return ResponseEntity.ok(this.productService.update(id.product));


}
@DeleteMapping(path = "/{id}")
public ResponseEntity<void> delete(@PathVariable Long id);

this.productService.delete(id);

return ResponseEntity.noContent().build();

}
