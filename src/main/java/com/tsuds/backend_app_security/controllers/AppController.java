package com.tsuds.backend_app_security.controllers;

import com.tsuds.backend_app_security.models.pojo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("")
    public Message index() {
        return new Message("This application is running");
    }
}
