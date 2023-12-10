package com.tiesch.boot.springboot.controller;

import com.tiesch.boot.springboot.model.User;
import com.tiesch.boot.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/addUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "info";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {

        userService.deleteUser(id);

        return "redirect:/users";
    }

    @RequestMapping("/update")
    public String updateUser(@RequestParam("id") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "info";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
    }
}
