package com.devsuperior.dsdeliver.demo.services;

import com.devsuperior.dsdeliver.demo.dto.ProductDTO;
import com.devsuperior.dsdeliver.demo.entities.Product;
import com.devsuperior.dsdeliver.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> fildAll(){
        List<Product> list = repository.findAllByOrderByNameDesc();
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
