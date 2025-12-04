package com.devsuperior.course.resources;

import com.devsuperior.course.entities.Order;
import com.devsuperior.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//controlador rest
//recurso web e implementado por um controlador Rest
@RestController
@RequestMapping(value = "/orders")//caminho para o recurso
public class OrderResource {

    @Autowired
    private OrderService service;//dependência para o service

    //endpoint para acessar os usuários
    @GetMapping//metodo para responder tipo GET do http
    public ResponseEntity<List<Order>> findAll() {//reponsavel para retornar respostas de requisições web
        List<Order> list = service.findAll();
        //User u = new User(1L,"Carlos","carlos@gmail.com","999999999","12345" );
        //return ResponseEntity.ok().body(u);//.ok quer dizer para voltar com sucesso no http
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")//indica que a requisição vai aceitar um id
    public ResponseEntity<Order> findId (@PathVariable Long id) {//para o spring aceitar o id passado no endpoint, precisa incluir a anotação pathvariable
        Order obj = service.findById(id);//repassando o id que chegou na requisição
        return ResponseEntity.ok().body(obj);

    }



}
