package com.mourarezendecas.annotationsapp.Repository;

import com.mourarezendecas.annotationsapp.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
