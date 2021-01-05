package com.devsuperior.dsdeliver.demo.services;

import com.devsuperior.dsdeliver.demo.dto.OrderDTO;
import com.devsuperior.dsdeliver.demo.dto.ProductDTO;
import com.devsuperior.dsdeliver.demo.entities.Order;
import com.devsuperior.dsdeliver.demo.entities.OrderStatus;
import com.devsuperior.dsdeliver.demo.entities.Product;
import com.devsuperior.dsdeliver.demo.repositories.OrderRepository;
import com.devsuperior.dsdeliver.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        for(ProductDTO p: dto.getProducts()){
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
