package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.UsuarioVIP; // Importe o UsuarioVIP
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

        // Aqui criamos instanciando a classe FILHA especificamente
        UsuarioVIP usuario = new UsuarioVIP();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setTipo(dto.tipo());
        usuario.setPontos(100);

        // Vamos dar o cartão de fidelidade por padrão para o teste
        usuario.setTemCartaoFidelidade(true);

        return usuario; // Retorna como Usuario, respeitando o polimorfismo!
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