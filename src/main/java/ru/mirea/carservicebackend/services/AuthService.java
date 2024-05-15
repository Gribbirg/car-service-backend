package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.dto.UserDto;
import ru.mirea.carservicebackend.models.User;

import java.util.List;

/**
 * The interface Auth service.
 */
public interface AuthService {
    /**
     * Register user.
     *
     * @param user the user
     */
    void registerUser(User user);

    /**
     * Sets user role.
     *
     * @param userId the user id
     * @param role   the role
     */
    void setUserRole(Long userId, User.Role role);

    /**
     * Sets user block.
     *
     * @param userId   the user id
     * @param isBocked the is bocked
     */
    void setUserBlock(Long userId, Boolean isBocked);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<UserDto> getAllUsers();
}
