package com.devsuperior.course.services;

import com.devsuperior.course.entities.Category;
import com.devsuperior.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    //buscar todas as categorias
    public List<Category> findAll() {
        return repository.findAll();
    }

    //buscar categorias por ID
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();//get() vai retonar o objeto do tipo Category
    }
}
