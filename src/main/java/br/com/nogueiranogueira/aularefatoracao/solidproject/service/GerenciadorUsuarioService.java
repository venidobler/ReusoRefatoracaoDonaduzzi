package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciadorUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // O Spring pega todas as classes que implementam RegraUsuario e tem @Component
    // e joga automaticamente dentro desta lista!
    @Autowired
    private List<RegraUsuario> regrasUsuario;

    public Usuario criarUsuario(UsuarioDTO dto) {

        for (RegraUsuario regra : regrasUsuario) {
            if (regra.aceita(dto.tipo())) {
                // A regra constrói e valida o usuário
                Usuario usuarioProcessado = regra.processar(dto);
                // O Service apenas salva no banco
                return usuarioRepository.save(usuarioProcessado);
            }
        }

        // Se passar por todas as regras e nenhuma aceitar:
        throw new IllegalArgumentException("Tipo inválido");
    }
}