package com.devsuperior.course.resources;

import com.devsuperior.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controlador rest

@RestController//recurso web e implementado por um controlador Rest
@RequestMapping(value = "/users")//caminho para o recurso
public class UserResource {

    //endpoint para acessar os usuarios
    @GetMapping//metodo para resopnder tipo GET do http
    public ResponseEntity<User> findAll() {//reponsavel para retornar respostas de requisições web
        User u = new User(1L,"Carlos","carlos@gmail.com","999999999","12345" );
        return ResponseEntity.ok().body(u);//.ok quer dizer para voltar com sucesso no http
    }
}
