package ru.mirea.carservicebackend.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.carservicebackend.config.AppUserDetails;
import ru.mirea.carservicebackend.dto.UserDto;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.repositories.UserRepository;

import java.util.List;

/**
 * The type Auth service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).orElse(null) != null) {
            throw new UsernameNotFoundException("Email already exists");
        }
        user.setRole(User.Role.client);
        user.setBlocked(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info(user.toString());
        userRepository.save(user);
    }

    @Override
    public void setUserRole(Long userId, User.Role role) {
        log.info("Set role \"{}\" for user with id {}", role.name(), userId);
        User user = userRepository.findById(userId).orElseThrow();
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public void setUserBlock(Long userId, Boolean isBocked) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setBlocked(isBocked);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(User::toDto).toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserDetails(user);
    }
}
