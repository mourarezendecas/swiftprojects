package com.mourarezendecas.annotationsapp.DTO.Response;

import com.mourarezendecas.annotationsapp.Entity.Todo;

import java.util.Date;

public record TodoResponseDTO(Long id, String title, String description, Boolean isDone, Date createdOn, Date updatedOn) {
    public TodoResponseDTO(Todo todo) {
        this(todo.getId(), todo.getTitle(), todo.getDescription(), todo.getIsDone(), todo.getCreatedOn(), todo.getUpdatedOn());
    }
}
