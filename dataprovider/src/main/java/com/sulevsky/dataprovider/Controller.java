package com.sulevsky.dataprovider;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${default-message}")
    private String message;

    @GetMapping("/message")
    public Message readMessage() {
        String id = UUID.randomUUID().toString();
        return new Message(id, message);
    }
}
