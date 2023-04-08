package com.example.library.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.library.Role;
import com.example.library.User;
import com.example.library.Repository.UserRepository;
import com.example.library.Repository.RoleRepository;


@Service
public class UserService {
    public static final Object addNewUser = null;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } 
        Collection <SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.get().getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
       return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), authorities);

    }

    //Get all users Service
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Get user by id Service
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exist"));
    }
    
    //Add user Service
    public User addNewUser(User user) {
        Optional<User> userOptional = userRepository.findByUserName(user.getUserName());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        return userRepository.save(user);
    }

    //Add role Service
    public Role addNewRole(Role role){
        Optional<Role> roleOptional = roleRepository.findByName(role.getName());
        if (roleOptional.isPresent()) {
            throw new IllegalStateException("Role already exists");
        }
        return roleRepository.save(role);
    }

    //Add role to user Service
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new IllegalStateException("User with id " + userName + " does not exist"));
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new IllegalStateException("Role with id " + roleName + " does not exist"));
        user.getRoles().add(role);
        userRepository.save(user);
    }


    //Delete user Service
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }
}
