package com.devsuperior.course.repositories;

import com.devsuperior.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
//repository são interfaces
//responsavel por fazer operações com a entidade Order
public interface OrderRepository extends JpaRepository<Order, Long> {//tipo da entidade e o tipo do ID


}
