package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NotificacaoEmailService notificacaoService;

    public void criarUsuario(Usuario usuario) {
        // 1. Validações de regra de negócio
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalStateException("E-mail já cadastrado");
        }

        // 2. Persistência (Salvar no banco)
        usuarioRepository.save(usuario);

        // 3. Notificação (Enviar e-mail)
        notificacaoService.enviarEmailBoasVindas(usuario);
    }
}