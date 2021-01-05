package com.devsuperior.dsdeliver.demo.services;

import com.devsuperior.dsdeliver.demo.dto.OrderDTO;
import com.devsuperior.dsdeliver.demo.entities.Order;
import com.devsuperior.dsdeliver.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
}
