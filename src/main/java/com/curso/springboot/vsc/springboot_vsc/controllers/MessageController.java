package com.curso.springboot.vsc.springboot_vsc.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.springboot.vsc.springboot_vsc.models.MessageDTO;

@RestController
public class MessageController {
    
    @GetMapping("/api/message")
    public MessageDTO messageView() {
        return new MessageDTO(LocalDateTime.now(), "Hola mundo con spring boot");
    }
}
