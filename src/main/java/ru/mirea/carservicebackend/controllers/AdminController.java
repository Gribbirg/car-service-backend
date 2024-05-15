package ru.mirea.carservicebackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.carservicebackend.dto.UserDto;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.services.AuthService;

import java.util.List;

/**
 * The type Admin controller.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/admin")
public class AdminController {

    private final AuthService authService;

    /**
     * Sets user role.
     *
     * @param userId  the user id
     * @param roleStr the role str
     */
    @PostMapping(value = "/set_role/{userId}")
    @ResponseBody
    public void setUserRole(@PathVariable(name = "userId") Long userId, @RequestParam String roleStr) {
        User.Role role = User.Role.valueOf(roleStr);
        authService.setUserRole(userId, role);
    }

    /**
     * Block user.
     *
     * @param userId      the user id
     * @param blockStatus the block status
     */
    @PostMapping(value = "/block/{userId}")
    @ResponseBody
    public void blockUser(@PathVariable(name = "userId") Long userId, @RequestParam Boolean blockStatus) {
        authService.setUserBlock(userId, blockStatus);
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @GetMapping(value = "/users")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        return authService.getAllUsers();
    }
}
