package com.strpad.com.strpad.controller;

import com.strpad.com.strpad.entity.Note;
import com.strpad.com.strpad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class NoteRest {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{url}")
    public ModelAndView loadFromUrl(@PathVariable String url) throws IOException {

        Note note = noteService.findNoteByUrl(url);

        System.out.println("url: " + note.getUrl());
        System.out.println("text: " + note.getText());

        ModelAndView mv = new ModelAndView("note");
        mv.addObject("note", note);

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestBody Note note) {

        System.out.println("note.getUrl(): "+note.getUrl());
        System.out.println("note.getText(): "+note.getText());

        noteService.save(note);

        ModelAndView mv = new ModelAndView("note");
        mv.addObject("note", note);
        return mv;
    }

}
