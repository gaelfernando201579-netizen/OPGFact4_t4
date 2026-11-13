package com.ito.OPGFact4_t4.service;

import com.ito.OPGFact4_t4.dto.AuthResponseDTO;
import com.ito.OPGFact4_t4.dto.LoginDTO;
import com.ito.OPGFact4_t4.dto.RegistroDTO;
import com.ito.OPGFact4_t4.entity.Usuario;
import com.ito.OPGFact4_t4.repository.UsuarioRepository;
import com.ito.OPGFact4_t4.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponseDTO registrar(RegistroDTO request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado en el sistema");
        }

        Usuario usuario = Usuario.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        usuarioRepository.save(usuario);

        String jwtToken = jwtService.generateToken(usuario);
        return AuthResponseDTO.builder().token(jwtToken).build();
    }

    public AuthResponseDTO login(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(usuario);
        return AuthResponseDTO.builder().token(jwtToken).build();
    }
}
