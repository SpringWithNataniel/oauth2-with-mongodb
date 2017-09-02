/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oauth2.mongodb.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import br.com.oauth2.mongodb.entity.User;
import br.com.oauth2.mongodb.repository.UserRepository;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    private String username;
    
    public String generateRandomEmail(){
        return UUID.randomUUID().toString();
    }

    public User getUserLogged() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            this.username = ((UserDetails) principal).getUsername();
        } else {
            this.username = principal.toString();
        }

        User userLogged = this.userRepository.findByEmail(this.username);
        userLogged.setEmail(userLogged.getEmail() + this.generateRandomEmail());
        
        return userLogged;
    }
    
}
