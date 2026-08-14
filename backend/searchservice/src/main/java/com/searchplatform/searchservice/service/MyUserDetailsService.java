package com.searchplatform.searchservice.service;


import com.searchplatform.searchservice.entity.User;
import com.searchplatform.searchservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public MyUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {

        User user = repo.findByUserName(usernameOrEmail);

        if (user == null) {
            user = repo.findByEmail(usernameOrEmail);
        }

        if (user == null) {
            throw new UsernameNotFoundException(
                    "User not found with username/email: " + usernameOrEmail
            );
        }

        return new UserPrincipal(user);
    }
}