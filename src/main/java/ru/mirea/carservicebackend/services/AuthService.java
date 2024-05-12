package ru.mirea.carservicebackend.services;

import ru.mirea.carservicebackend.models.User;

public interface AuthService {
    void registerUser(User user);
}
