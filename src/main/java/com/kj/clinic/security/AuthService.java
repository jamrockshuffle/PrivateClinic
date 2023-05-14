package com.kj.clinic.security;

import com.kj.clinic.security.dto.LoginRequest;
import com.kj.clinic.security.dto.LoginResponse;
import com.kj.clinic.security.dto.SignUpRequest;
import com.kj.clinic.security.dto.SignUpRequestNoLogin;
import com.kj.clinic.security.model.Role;
import com.kj.clinic.security.model.User;
import com.kj.clinic.security.repository.RoleRepository;
import com.kj.clinic.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse authenticateRequest(LoginRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        var jwt = jwtUtils.generateJwtToken(auth);
        var details = (UserDetailsImpl) auth.getPrincipal();
        var roles = details.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return LoginResponse.builder()
                .jwt(jwt)
                .username(details.getUsername())
                .roles(roles)
                .build();
    }

    public User signUpUser(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username " + request.getUsername() + " already exists");
        }

        String id = String.valueOf(userRepository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        var user = User.builder()
                .id(id)
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .roleIds(mapRoles(request)).build();

        userRepository.save(user);

        return user;
    }

    public String signUpUserNoLogin(SignUpRequestNoLogin request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username " + request.getUsername() + " already exists");
        }

        String id = String.valueOf(userRepository.findAll()
                .stream()
                .mapToInt(el -> Integer.parseInt(el.getId())).max().orElse(0) + 1);

        var user = User.builder()
                .id(id)
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .roleIds(mapRolesNoLogin(request)).build();

        userRepository.save(user);

        return "User was successfully created";
    }


    private Set<Role> mapRoles(SignUpRequest request) {
        return request.getRoles()
                .stream()
                .map(this::mapStringToRole)
                .collect(Collectors.toSet());
    }

    private Set<Role> mapRolesNoLogin(SignUpRequestNoLogin request) {
        return request.getRoles()
                .stream()
                .map(this::mapStringToRole)
                .collect(Collectors.toSet());
    }

    private Role mapStringToRole(String roleString) {
        return roleRepository.findByName(Role.ERole.valueOf(roleString))
                .orElseThrow(() -> new IllegalArgumentException("Wrong name of role " + roleString));
    }
}
