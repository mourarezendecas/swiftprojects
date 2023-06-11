package com.mourarezendecas.annotationsapp.Entity;

import com.mourarezendecas.annotationsapp.DTO.Request.TodoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "todos")
@Entity(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean isDone;
    private Date createdOn;
    private Date updatedOn;

    public Todo(TodoRequestDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.isDone = false;
        this.createdOn = new Date();
        this.updatedOn = new Date();
    }
}
