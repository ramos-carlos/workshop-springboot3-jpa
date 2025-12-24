package com.devsuperior.course.services;

import com.devsuperior.course.entities.User;
import com.devsuperior.course.repositories.UserRepository;
import com.devsuperior.course.services.exceptions.DatabaseException;
import com.devsuperior.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component//registra como um componente do spring e pode ser injetado no UserResource com autowired
@Service//registra como serviço
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
        //return obj.get();//get() vai retornar o objeto do tipo User
        //se não tiver usuario, ele lança a exceção
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //inserir usuario
    public User insert(User obj) {
        return repository.save(obj);
    }

    //deletar usuario
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    //atualizar usuario
    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}




