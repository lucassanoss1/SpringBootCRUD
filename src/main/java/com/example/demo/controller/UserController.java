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
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/allUsers";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping("/add")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/allUsers";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/allUsers";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(User user){
        userService.updateUser(user);
        return "redirect:/allUsers";
    }
}
