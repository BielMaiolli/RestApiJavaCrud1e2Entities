package com.example.ProjetoGithub.controllers;

import com.example.ProjetoGithub.entities.User;
import com.example.ProjetoGithub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserControler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = userRepository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = userRepository.findById(id).get();
        return result;
    }

    @PostMapping
    public User insert(@RequestBody User user){
        User result = userRepository.save(user);
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public User updateById(@PathVariable Long id, @RequestBody User updateById){
        return userRepository.findById(id).map(user -> {
            user.setId(updateById.getId());
            user.setNome(updateById.getNome());

            return userRepository.save(user);

        }).orElse(null);

    }
}
