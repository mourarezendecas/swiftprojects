package com.mourarezendecas.annotationsapp.DTO.Request;

import java.util.Date;

public record TodoRequestDTO(String title, String description, Boolean isDone, Date createdOn, Date updatedOn) {

}
