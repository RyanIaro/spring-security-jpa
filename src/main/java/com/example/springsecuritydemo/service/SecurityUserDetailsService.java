package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.SecurityUser;
import com.example.springsecuritydemo.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return securityUserRepository.findSecurityUserByUsername(username);
    }

    public SecurityUser defaultSave() {
        SecurityUser user = new SecurityUser();
        user.setUsername("user");
        user.setPassword(new BCryptPasswordEncoder().encode("password"));
        user.setAuthority("admin");
        return securityUserRepository.save(user);
    }

    public SecurityUser getByUsername(String username) {
        return securityUserRepository.findSecurityUserByUsername(username);
    }
    public List<SecurityUser> getAll() {
        return securityUserRepository.findAll();
    }

    public Optional<SecurityUser> getById(int securityUserId) {
        return securityUserRepository.findById(securityUserId);
    }

    @Transactional
    public List<SecurityUser> saveAll(List<SecurityUser> securityUsers) {
        return securityUserRepository.saveAll(securityUsers);
    }

}
