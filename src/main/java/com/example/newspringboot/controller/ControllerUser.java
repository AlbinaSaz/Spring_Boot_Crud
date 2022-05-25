package com.example.newspringboot.controller;


import com.example.newspringboot.Service.UserService;
import com.example.newspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class ControllerUser {

    @Autowired
    private UserService serviceUser;

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        serviceUser.save(user);
        return "redirect:/users";
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("user", serviceUser.allUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", serviceUser.findUser(id));
        return "findUser";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", serviceUser.findUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        serviceUser.updateUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        serviceUser.deleteUser(id);
        return "redirect:/users";
    }
}
