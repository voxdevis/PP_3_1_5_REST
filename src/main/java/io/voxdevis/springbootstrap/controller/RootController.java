package io.voxdevis.springbootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping("/")
    public String startPage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

}