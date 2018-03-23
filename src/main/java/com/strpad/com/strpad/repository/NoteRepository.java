package com.strpad.com.strpad.repository;


import com.strpad.com.strpad.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

    Optional<Note> findByUrl(String url);
}
