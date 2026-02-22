package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // O Spring Data JPA cria o "SELECT COUNT" automaticamente só pelo nome desse método!
    boolean existsByEmail(String email);

}