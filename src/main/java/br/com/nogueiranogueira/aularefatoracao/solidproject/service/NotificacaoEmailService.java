package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoEmailService {

    // DIP Aplicado: Dependemos da INTERFACE, e não da classe SmtpEmailService.
    // O Spring vai procurar quem implementa EmailService e injetar aqui automaticamente!
    @Autowired
    private EmailService emailService;

    public void enviarEmailBoasVindas(Usuario usuario) {
        String assunto = "Bem-vindo!";
        String corpo = "Olá " + usuario.getNome() + ", seu cadastro foi realizado com sucesso.";

        emailService.sendEmail(usuario.getEmail(), assunto, corpo);
    }
}