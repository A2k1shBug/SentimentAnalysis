package com.example.demo.sentiment_analysis.security;

import com.example.demo.sentiment_analysis.user.model.Users;
import com.example.demo.sentiment_analysis.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users userRepoByUserName = userRepo.findByUserName(username);
        if (userRepoByUserName!=null){
            return User.builder().username(userRepoByUserName.getUserName())
                    .password(userRepoByUserName.getPassword())
                    .roles(userRepoByUserName.getRoles().toArray(new String[0])).build();
        }
        log.error("Error is happened due in UserNameNotFoundException");
        throw new UsernameNotFoundException("User Not found exception");
    }
}
