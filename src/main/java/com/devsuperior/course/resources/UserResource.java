package com.devsuperior.course.resources;

import com.devsuperior.course.entities.User;
import com.devsuperior.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//controlador rest

@RestController//recurso web e implementado por um controlador Rest
@RequestMapping(value = "/users")//caminho para o recurso
public class UserResource {

    @Autowired
    private UserService service;//dependencia para o service

    //endpoint para acessar os usuarios
    @GetMapping//metodo para responder tipo GET do http
    public ResponseEntity<List<User>> findAll() {//reponsavel para retornar respostas de requisições web
        List<User> list = service.findAll();
        //User u = new User(1L,"Carlos","carlos@gmail.com","999999999","12345" );
        //return ResponseEntity.ok().body(u);//.ok quer dizer para voltar com sucesso no http
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")//indica que a requisição vai aceitar um id
    public ResponseEntity<User> findById(@PathVariable Long id) {//para o spring aceitar o id passado no endpoint, precisa incluir a anotação pathvariable
        User obj = service.findById(id);//repassando o id que chegou na requisição
        return ResponseEntity.ok().body(obj);
    }

}
