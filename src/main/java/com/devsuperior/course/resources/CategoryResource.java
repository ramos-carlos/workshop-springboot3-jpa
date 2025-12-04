package com.devsuperior.course.resources;


import com.devsuperior.course.entities.Category;
import com.devsuperior.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")//indica que a requisição vai aceitar um id
   public ResponseEntity<Category> findById(@PathVariable Long id) {//para o spring aceitar o id passado no endpoint, precisa incluir a anotação pathvariable
        Category obj = service.findById(id);//repassando o id que chegou na requisição
        return ResponseEntity.ok().body(obj);
   }

}
