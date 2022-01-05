package com.banksystem.controllers;

import com.banksystem.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }


    @GetMapping("/user")
    public String clients(Model model) {
        model.addAttribute("clients" , service.getUsers());
        return "user";
    }
}
