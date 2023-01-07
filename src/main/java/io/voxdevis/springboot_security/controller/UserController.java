package io.voxdevis.springboot_security.controller;


import io.voxdevis.springboot_security.entity.User;
import io.voxdevis.springboot_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String workScreen(ModelMap model) {
        List<User> users = userService.showAll();
        model.addAttribute("users", users);
        return "restricted/allUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {

         model.addAttribute("user", new User());

        return "restricted/addUser";
    }


    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:restricted/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "restricted/card";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "restricted/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:restricted/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:restricted/";
    }

}
