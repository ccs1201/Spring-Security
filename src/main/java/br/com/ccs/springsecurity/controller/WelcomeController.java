package br.com.ccs.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    protected String get() {
        return "Bem Vindo !";
    }

    @GetMapping("/users")
    protected String getUser() {
        return "Role USERS Autorizada.";
    }

    @GetMapping("/managers")
    protected String getManager() {
        return "Role MANAGERS Autorizada.";
    }
}
