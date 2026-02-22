package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioVIP implements RegraUsuario {

    @Override
    public boolean aceita(String tipo) {
        return "VIP".equals(tipo);
    }

    @Override
    public Usuario processar(UsuarioDTO dto) {
        validarEmail(dto.email());
        validarIdade(dto.idade());

        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(100);
        return usuario;
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validarIdade(int idade){
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário VIP deve ser maior de idade");
        }
    }
}