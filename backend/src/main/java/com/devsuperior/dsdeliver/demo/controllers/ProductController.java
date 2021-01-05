package com.devsuperior.dsdeliver.demo.controllers;

import com.devsuperior.dsdeliver.demo.dto.ProductDTO;
import com.devsuperior.dsdeliver.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> list = service.fildAll();
        return ResponseEntity.ok().body(list);
    }
}
