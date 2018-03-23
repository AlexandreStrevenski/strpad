package com.strpad.com.strpad.service;


import com.strpad.com.strpad.entity.Note;
import com.strpad.com.strpad.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note findNoteByUrl(String url) {
        return noteRepository.findByUrl(url).orElse(new Note());
    }

    public void save(Note note) {
        noteRepository.save(note);
    }
}
