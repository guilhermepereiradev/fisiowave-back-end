package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.dto.LoginRequest;
import com.grupo3.fisiowave.dto.LoginResponse;
import com.grupo3.fisiowave.model.User;
import com.grupo3.fisiowave.repository.UserRepository;
import com.grupo3.fisiowave.service.exception.BadCredentialException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtEncoder jwtEncoder;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public LoginResponse login(LoginRequest request) {
        var user = repository.findByEmail(request.getEmail());

        if (user.isEmpty() || !user.get().isLoginCorreto(request.getPassword(), passwordEncoder)) {
            throw new BadCredentialException("Usuário ou senha inválidos.");
        }

        var now = Instant.now();
        var expiresIn = 86400L;

        var claims = JwtClaimsSet.builder()
                .issuer("fisiowave-back-end")
                .subject(user.get().getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", getScope(user.get()))
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn);

    }

    private String getScope(User user) {
        return user.isAdmin() ? "ADMIN" : "PATIENT";
    }
}
