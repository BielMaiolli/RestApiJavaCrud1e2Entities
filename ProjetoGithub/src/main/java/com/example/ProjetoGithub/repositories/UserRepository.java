package com.example.ProjetoGithub.repositories;

import com.example.ProjetoGithub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
