package com.example.demo.controller;

import com.example.demo.player.PlayerGround;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private static Logger log = LoggerFactory.getLogger(PlayerController.class);
    private PlayerGround service;

    public PlayerController(PlayerGround service) {
        this.service = service;
    }



    @PostMapping("/run")
    public void run() {
        log.info("Running schedule service");
        service.runHelloWorldJob();
    }
}
