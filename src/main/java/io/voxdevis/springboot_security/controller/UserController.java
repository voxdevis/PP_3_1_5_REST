package io.voxdevis.springboot_security.controller;


import io.voxdevis.springboot_security.entity.User;
import io.voxdevis.springboot_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index() {
        return "index";
    }


    @GetMapping("/user")
    public String pageForUser (Model model, Principal principal) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "user";
    }

}
