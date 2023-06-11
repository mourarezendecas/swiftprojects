package com.mourarezendecas.annotationsapp.Entity;

import com.mourarezendecas.annotationsapp.DTO.Request.NoteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "notes")
@Entity(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Date createdOn;
    private Date uptadatedOn;

    public Note(NoteRequestDTO data) {
        this.title = data.title();
        this.content = data.content();
        this.createdOn = new Date();
        this.uptadatedOn = new Date();
    }
}
