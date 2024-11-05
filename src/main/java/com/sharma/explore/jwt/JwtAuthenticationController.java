package com.sharma.explore.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharma.explore.services.UserService;

@RestController
public class JwtAuthenticationController {

    private final JwtTokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    public JwtAuthenticationController(JwtTokenService tokenService,
            AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(
            @RequestBody JwtTokenRequest jwtTokenRequest) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtTokenRequest.username(),
                jwtTokenRequest.password());

        var authentication = authenticationManager.authenticate(authenticationToken);

        var token = tokenService.generateToken(authentication);

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }
}