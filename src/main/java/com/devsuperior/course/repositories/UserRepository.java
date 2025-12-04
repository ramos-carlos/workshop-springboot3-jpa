package com.devsuperior.course.repositories;

import com.devsuperior.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//repository são interfaces
//responsável por fazer operações com a entidade User
public interface UserRepository extends JpaRepository<User, Long> {//tipo da entidade e o tipo do ID


}
