package com.strpad.com.strpad.controller;

import com.strpad.com.strpad.entity.Note;
import com.strpad.com.strpad.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NoteRest {

    @Autowired
    private NoteService noteService;

    @GetMapping("/{url}")
    public ModelAndView loadFromUrl(@PathVariable String url) {

        Note note = noteService.findNoteByUrl(url);

        System.out.println("url: " + note.getUrl());
        System.out.println("text: " + note.getText());

        ModelAndView mv = new ModelAndView("note");
        mv.addObject("note", note);

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestBody String value) {
        Note note = toNote(value);
        System.out.println("note.getUrl(): "+note.getUrl());
        System.out.println("note.getText(): "+note.getText());

        noteService.save(note);

        ModelAndView mv = new ModelAndView("note");
        mv.addObject("note", note);
        return mv;
    }

    private Note toNote(String value) {
        String[] split = value.split(":");
        Note note = new Note();
        note.setUrl(split[0]);
        note.setText(split[1]);
        return note;
    }

}
