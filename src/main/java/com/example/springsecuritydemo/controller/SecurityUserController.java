package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.SecurityUser;
import com.example.springsecuritydemo.service.SecurityUserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SecurityUserController {

    private SecurityUserDetailsService securityUserService;

    @GetMapping("/security")
    public List<SecurityUser> getSecurityUsers() {
        return securityUserService.getAll();
    }

    @GetMapping("/security/{securityUserId}")
    public Optional<SecurityUser> getSecurityUserById(@PathVariable int securityUserId) {
        return securityUserService.getById(securityUserId);
    }

    @GetMapping("security/{securityUsername}")
    public SecurityUser getSecurityUserByUsername(@PathVariable String username) {
        return securityUserService.getByUsername(username);
    }

    @PostMapping("/security/default")
    public SecurityUser saveDefault() {
        return securityUserService.defaultSave();
    }

    @PostMapping("/security")
    public List<SecurityUser> saveSecurityUsers(@RequestBody List<SecurityUser> securityUsers) {
        return securityUserService.saveAll(securityUsers);
    }

}
