package com.devsuperior.course.services;

import com.devsuperior.course.entities.Product;
import com.devsuperior.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//registra como serviço
public class ProductService {
    //declarando dependencia do repository
    @Autowired
    private ProductRepository repository;

    //buscar todos os produtos
    public List<Product> findAll() {
        return repository.findAll();
    }

    //buscar order por ID
    public Product findById (Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();//get() vai retornar o objeto do tipo Product
    }

}
