package ru.mirea.carservicebackend.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.carservicebackend.config.AppUserDetails;
import ru.mirea.carservicebackend.models.User;
import ru.mirea.carservicebackend.repositories.UserRepository;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AppUserDetails(user);
    }
}
