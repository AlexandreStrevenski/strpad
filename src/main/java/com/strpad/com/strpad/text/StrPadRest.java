package com.strpad.com.strpad.text;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alexandre S on 13/01/2018.
 */

@Controller
public class StrPadRest {


    @GetMapping("/{url}")
    public ModelAndView start(@PathVariable String url) {
        String text = "";
        if (ListURL.contains(url)){
            text = ListURL.getText(url);
        }else{
            ListURL.putText(url, "");
        }
        System.out.println("url"+url);
        System.out.println("text"+text);

        ModelAndView mv = new ModelAndView("pad");
        mv.addObject("pad", new Pad(url, text));

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestBody String value) {
        Pad pad = toPad(value);
        System.out.println("pad.getUrl():"+pad.getUrl());
        System.out.println("pad.getText():"+pad.getText());
        ListURL.putText(pad.getUrl(), pad.getText());
        ModelAndView mv = new ModelAndView("pad");
        mv.addObject("pad", pad);
        return mv;
    }

    private Pad toPad(String value) {
        String[] split = value.split(":");
        return new Pad(split[0], split[1]);
    }

}
