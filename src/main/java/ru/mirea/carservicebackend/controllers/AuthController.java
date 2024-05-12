package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.services.AuthService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/registration")
    public void registerUser(@RequestBody User user) {
        authService.registerUser(user);
    }
}
