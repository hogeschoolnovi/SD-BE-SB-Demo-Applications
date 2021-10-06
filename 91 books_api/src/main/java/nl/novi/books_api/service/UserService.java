package nl.novi.books_api.service;

import nl.novi.books_api.exceptions.RecordNotFoundException;
import nl.novi.books_api.exceptions.UsernameNotFoundException;
import nl.novi.books_api.model.Authority;
import nl.novi.books_api.model.User;
import nl.novi.books_api.repository.UserRepository;
import nl.novi.books_api.utils.RandomStringGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(User user) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        user.setApikey(randomString);

        String password = user.getPassword();
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);

        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).orElse(null);

        String password = user.getPassword();
        String encoded = passwordEncoder.encode(password);
        user.setPassword(encoded);

        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).orElse(null);
        return user.getAuthorities();
    }

    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).orElse(null);
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).orElse(null);
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().orElse(null);
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

}