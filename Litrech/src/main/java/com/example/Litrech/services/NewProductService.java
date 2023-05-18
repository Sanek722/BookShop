package com.example.Litrech.services;

import com.example.Litrech.Repository.ProductRepository;
import com.example.Litrech.models.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class NewProductService
{

    @Autowired
    private ProductRepository productRepository;
    public void add(Product product) {
        productRepository.saveAndFlush(product);
    }
    public void delete(int id) {
        productRepository.deleteById(id);
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void updateProduct(Product product)
    {
        productRepository.saveAndFlush(product);
    }

    public String getAuthor(int id) {

        return productRepository.findAuthorById(id);
    }

    public int getPrice(int id)
    {
        return productRepository.findPriceById(id);
    }
    public String getNamebook(int id)
    {
        return productRepository.findNamebookById(id);
    }
    public Product getProduct(Integer id)
    {
        return productRepository.getReferenceById(id);
    }
}
