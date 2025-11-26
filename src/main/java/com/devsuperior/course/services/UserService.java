package com.devsuperior.course.services;

import com.devsuperior.course.entities.User;
import com.devsuperior.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component //registra como um componente do spring e pode ser injetado no UserResource com autowired
@Service //registra como serviço
public class UserService {
    //declarando dependencia do repository
    @Autowired//injeção de dependencia
    private UserRepository repository;

    //buscar todos os usuarios
    public List<User> findAll() {
        return repository.findAll();
    }

    //buscar usuarios por ID
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();//get() vai retornar o objeto do tipo User
    }
}




