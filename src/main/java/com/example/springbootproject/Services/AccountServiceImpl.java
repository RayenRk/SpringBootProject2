package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.AppRole;
import com.example.springbootproject.Entity.AppUser;
import com.example.springbootproject.Repository.AppRoleRepository;
import com.example.springbootproject.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user=  appUserRepository.findByUsername(username);
        AppRole role =appRoleRepository.findByRoleName(roleName);
        user.getAppRoles().add(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}