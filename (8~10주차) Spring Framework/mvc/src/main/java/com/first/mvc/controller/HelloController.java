package com.first.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String helloUser(Model model) {
        model.addAttribute("username", "castle!");
        return "helloUser";
    }
}
