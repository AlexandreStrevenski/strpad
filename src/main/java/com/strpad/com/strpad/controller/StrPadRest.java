package com.strpad.com.strpad.controller;

import com.strpad.com.strpad.entity.Pad;
import com.strpad.com.strpad.service.PadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StrPadRest {

    @Autowired
    private PadService padService;

    @GetMapping("/{url}")
    public ModelAndView loadFromUrl(@PathVariable String url) {

        Pad pad = padService.findPadByUrl(url);

        System.out.println("url: "+pad.getUrl());
        System.out.println("text: "+pad.getText());

        ModelAndView mv = new ModelAndView("pad");
        mv.addObject("pad", pad);

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestBody String value) {
        Pad pad = toPad(value);
        System.out.println("pad.getUrl(): "+pad.getUrl());
        System.out.println("pad.getText(): "+pad.getText());

        padService.save(pad);

        ModelAndView mv = new ModelAndView("pad");
        mv.addObject("pad", pad);
        return mv;
    }

    private Pad toPad(String value) {
        String[] split = value.split(":");
        Pad pad = new Pad();
        pad.setUrl(split[0]);
        pad.setText(split[1]);
        return pad;
    }

}
