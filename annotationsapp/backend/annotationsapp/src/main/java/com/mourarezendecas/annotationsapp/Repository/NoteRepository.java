package com.mourarezendecas.annotationsapp.Repository;

import com.mourarezendecas.annotationsapp.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository <Note, Long> {
}
