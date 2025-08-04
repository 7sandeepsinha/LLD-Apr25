package dev.sandeep.BookMyShowApr25.controller;

import dev.sandeep.BookMyShowApr25.service.InitialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private InitialisationService initialisationService;

    @GetMapping("/init")
    public ResponseEntity init(){
        initialisationService.initialise();
        return ResponseEntity.ok(true);
    }
}
