package com.example.test.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.test.pojo.User;
import com.example.test.repository.userCrud;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationImplementation implements AuthenticationProvider {
    @Autowired
    private userCrud user;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String userName = authentication.getName();
            String password = authentication.getCredentials().toString();
            List<User> userDetails = user.findByUserName(userName);
            boolean isMatch = encoder.matches(password, userDetails.get(0).getPassword());
            log.info("Hello.");
            log.info(userDetails.toString());
            if (userDetails.size() == 0) {
                throw new BadCredentialsException("Invalid credentials");
            }

            if (isMatch) {
                return new UsernamePasswordAuthenticationToken(userName, null,
                        grantedAuthorities(userDetails));
            }

        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username");
        }
        throw new BadCredentialsException("Invalid Credentials");

    }

    public List<GrantedAuthority> grantedAuthorities(List<User> list) {
        List<GrantedAuthority> grant = List.of(new SimpleGrantedAuthority(list.get(0).getRole()));
        return grant;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
