package com.mourarezendecas.annotationsapp.DTO.Request;

import java.util.Date;

public record NoteRequestDTO(String title, String content, Date createdOn, Date updatedOn) {

}
