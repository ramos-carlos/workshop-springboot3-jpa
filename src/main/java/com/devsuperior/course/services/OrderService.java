package com.devsuperior.course.services;

import com.devsuperior.course.entities.Order;
import com.devsuperior.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//registra como serviço
public class OrderService {
    //declarando dependencia do repository
    @Autowired//injeção de dependencia
    private OrderRepository repository;


    //buscar todos as orders
    public List<Order> findAll() {
        return repository.findAll();
    }

    //buscar order por ID
    public Order findById (Long id) {
        Optional<Order> obj =  repository.findById(id);
        return obj.get();//get() vai retornar o objeto do tipo Order
    }
}
