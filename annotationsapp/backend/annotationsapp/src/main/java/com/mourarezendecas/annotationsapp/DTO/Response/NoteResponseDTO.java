package com.mourarezendecas.annotationsapp.DTO.Response;

import com.mourarezendecas.annotationsapp.Entity.Note;

import java.util.Date;

public record NoteResponseDTO(long id, String title, String content, Date createdOn, Date updatedOn) {
    public NoteResponseDTO(Note note) {
        this(note.getId(), note.getTitle(), note.getContent(), note.getCreatedOn(), note.getUptadatedOn());
    }
}
