package com.ito.OPGFact4_t4.repository;

import com.ito.OPGFact4_t4.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Spring Data JPA crea la consulta SQL automáticamente solo con nombrar bien el
    // método
    Optional<Usuario> findByEmail(String email);
}
