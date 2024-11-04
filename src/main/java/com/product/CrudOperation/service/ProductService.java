package com.product.CrudOperation.service;


import com.product.CrudOperation.entity.Product;
import com.product.CrudOperation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //post method for single object
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {

        return repository.save(product);

    }
//post method list products
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }
//get method all products
    public List<Product> getProducts() {
        return repository.findAll();

    }
//get method for single object by id
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
// get method for single object by name
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed || "+id;


    }
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}