package com.devsuperior.dsdeliver.demo.repositories;

import com.devsuperior.dsdeliver.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Product, Long> {

}
