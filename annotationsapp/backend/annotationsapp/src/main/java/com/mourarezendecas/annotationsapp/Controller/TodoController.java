package com.mourarezendecas.annotationsapp.Controller;

import com.mourarezendecas.annotationsapp.DTO.Request.TodoRequestDTO;
import com.mourarezendecas.annotationsapp.DTO.Response.TodoResponseDTO;
import com.mourarezendecas.annotationsapp.Entity.Todo;
import com.mourarezendecas.annotationsapp.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todo")
public class TodoController {
    @Autowired
    private TodoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Todo saveTodo(@RequestBody TodoRequestDTO data){
        return repository.save(new Todo(data));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<TodoResponseDTO> getAllTodos(){
        return repository.findAll().stream().map(TodoResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTodoById(@PathVariable("id") Long id){
        Optional<Todo> optionalTodo = repository.findById(id);

        if(optionalTodo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(optionalTodo.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable("id") Long id, @RequestBody TodoRequestDTO data){
        Optional<Todo> optionalTodo = repository.findById(id);

        if(optionalTodo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found.");
        }

        Todo todo = optionalTodo.get();

        if(data.title()!=null){
            todo.setTitle(data.title());
        }
        if(data.description()!=null) {
            todo.setDescription(data.description());
        }
        todo.setIsDone(data.isDone());
        todo.setCreatedOn(optionalTodo.get().getCreatedOn());
        todo.setUpdatedOn(new Date());

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(todo));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable("id") Long id){
        Optional<Todo> optionalTodo = repository.findById(id);

        if(optionalTodo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("To-do task not found.");
        }
        repository.delete(optionalTodo.get());
        return ResponseEntity.status(HttpStatus.OK).body("To-do task deleted successfully.");
    }
}
