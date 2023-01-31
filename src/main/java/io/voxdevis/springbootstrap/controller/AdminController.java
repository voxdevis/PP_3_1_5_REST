package io.voxdevis.springbootstrap.controller;


import io.voxdevis.springbootstrap.entity.User;
import io.voxdevis.springbootstrap.service.RoleService;
import io.voxdevis.springbootstrap.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;



@Controller
@RequestMapping("/admin")
public class AdminController {


    private UserService userService;


    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String adminPanel(Model model, Principal principal, @ModelAttribute("user") User user) {
        model.addAttribute("admin", userService.findUserByEmail(principal.getName()));
        model.addAttribute("users", userService.showAll());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("newUser", new User());

        return "admin/index";
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin/";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin/";
    }

}
