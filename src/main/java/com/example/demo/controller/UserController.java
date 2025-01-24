package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userServis;

    @Autowired
    public UserController(UserService userServis) {
        this.userServis = userServis;
    }

    @GetMapping("/allUsers")
    public String getAllUser(Model model) {
        model.addAttribute("users", userServis.getAllUsers());
        return "/allUsers";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping("/add")
    public String addUser(User user){
        userServis.addUser(user);
        return "redirect:/allUsers";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userServis.removeUserById(id);
        return "redirect:/allUsers";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServis.findUserById(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(User user){
        userServis.addUser(user);
        return "redirect:/allUsers";
    }
}
