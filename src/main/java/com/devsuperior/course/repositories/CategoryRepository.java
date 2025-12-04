package com.devsuperior.course.repositories;

import com.devsuperior.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository <Category, Long> {//tipo da entidade e o tipo do ID
}
