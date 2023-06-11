package com.mourarezendecas.annotationsapp.Controller;

import com.mourarezendecas.annotationsapp.DTO.Request.NoteRequestDTO;
import com.mourarezendecas.annotationsapp.Entity.Note;
import com.mourarezendecas.annotationsapp.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody NoteRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(new Note(data)));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getNoteById(@PathVariable("id") Long id){
        Optional<Note> optionalNote = repository.findById(id);
        if(optionalNote.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalNote.get());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNote(@PathVariable("id") Long id, @RequestBody NoteRequestDTO data){
        Optional<Note> noteOptional = repository.findById(id);
        if(noteOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found.");
        }

        Note note = noteOptional.get();
        if(data.title()!=null){
            note.setTitle(data.title());
        }
        if(data.content()!=null) {
            note.setContent(data.content());
        }
        note.setCreatedOn(noteOptional.get().getCreatedOn());
        note.setUptadatedOn(new Date());

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(note));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNote(@PathVariable("id") Long id){
        Optional<Note> noteOptional = repository.findById(id);

        if(noteOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found.");
        }
        repository.delete(noteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Note deleted successfully.");
    }
}
