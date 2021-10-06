package nl.novi.studentcourse.service;

import nl.novi.studentcourse.exceptions.ForbiddenException;
import nl.novi.studentcourse.exceptions.RecordNotFoundException;
import nl.novi.studentcourse.exceptions.UserNotFoundException;
import nl.novi.studentcourse.model.Authority;
import nl.novi.studentcourse.model.User;
import nl.novi.studentcourse.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    private Authentication getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication;
        }
        else {
            return null;
        }
    }

    private boolean currentUserHasFullAccessToAllUsers() {
        Authentication currentUser = getCurrentUser();
        if (currentUser == null) return false;
        return currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    private boolean currentUserHasAccessToUser(String username) {
        Authentication currentUser = getCurrentUser();
        if (currentUser == null) return false;
        if (currentUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return true;
        }
        else {
            return currentUser.getName().equalsIgnoreCase(username);
        }
    }

    public Collection<User> getUsers() {
        if (currentUserHasFullAccessToAllUsers()) {
            return userRepository.findAll();
        }
        else {
            if (getCurrentUser() == null) { return new ArrayList<>(); }
            return userRepository.findAllByUsername(getCurrentUser().getName());
        }
    }

    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    public Optional<User> getUserByUsername(String username) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        return userRepository.findByUsername(username);
    }

    public boolean userExists(String username) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        return userRepository.existsById(username);
    }

    public String createUser(User user) {
        if (!currentUserHasFullAccessToAllUsers()) { throw new ForbiddenException(); }
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        userRepository.deleteById(username);
    }

    public void updateUser(String username, User newUser) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        if (!userRepository.existsById(username)) { throw new RecordNotFoundException(); }
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        if (!userRepository.existsById(username)) { throw new UserNotFoundException(); }
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    public void addAuthority(String username, String authority) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        if (!userRepository.existsById(username)) { throw new UserNotFoundException(); }
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!currentUserHasAccessToUser(username)) { throw new ForbiddenException(); }
        if (!userRepository.existsById(username)) { throw new UserNotFoundException(); }
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

}
