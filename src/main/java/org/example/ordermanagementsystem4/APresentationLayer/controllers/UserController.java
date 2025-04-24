package org.example.ordermanagementsystem4.APresentationLayer.controllers;

import org.example.ordermanagementsystem4.APresentationLayer.DTOs.UserDTO;
import org.example.ordermanagementsystem4.BL.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
//@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserDTO> userDTOs=  userService.findAll();
        model.addAttribute("users", userDTOs);
        return "users";
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUserById(@PathVariable(name="id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDTO userDTO) {
            userService.create(userDTO);
        return "redirect:/users";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable(name="id") Long id, @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return "redirect:/users";
    }

    @PostMapping ("/delete/{id}")
    public String deleteById(@PathVariable(name="id") Long Id, RedirectAttributes redirectAttributes) {
        userService.deleteById(Id);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public void delete(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO);
    }

}

