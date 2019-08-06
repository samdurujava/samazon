package com.example.samazon.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemiController {

    @RequestMapping("/homepage")
    public String login() {
        return "homepage";
    }
}
