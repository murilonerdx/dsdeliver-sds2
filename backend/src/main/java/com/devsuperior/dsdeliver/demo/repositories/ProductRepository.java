package com.devsuperior.dsdeliver.demo.repositories;

import com.devsuperior.dsdeliver.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByNameDesc();

}
