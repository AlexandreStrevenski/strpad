package com.strpad.com.strpad.service;


import com.strpad.com.strpad.entity.Pad;
import com.strpad.com.strpad.repository.PadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PadService {

    @Autowired
    private PadRepository padRepository;

    public Pad findPadByUrl(String url) {
        return padRepository.findByUrl(url).orElse(new Pad());
    }

    public void save(Pad pad) {
        padRepository.save(pad);
    }
}
