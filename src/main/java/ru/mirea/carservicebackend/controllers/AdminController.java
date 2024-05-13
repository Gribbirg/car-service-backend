package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.services.AuthService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    private final AuthService authService;

    @PostMapping(value = "/set_role/{userId}")
    @ResponseBody
    public void setUserRole(@PathVariable(name = "userId") Long userId, @RequestParam String roleStr) {
        User.Role role = User.Role.valueOf(roleStr);
        authService.setUserRole(userId, role);
    }
}
