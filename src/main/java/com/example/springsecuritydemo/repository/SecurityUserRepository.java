package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {

    public SecurityUser findSecurityUserByUsername(String username);
}
