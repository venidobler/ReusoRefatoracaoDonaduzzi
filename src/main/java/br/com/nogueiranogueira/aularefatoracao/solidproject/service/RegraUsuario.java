package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

public interface RegraUsuario {
    // Retorna true se a regra serve para o tipo (ex: "COMUM" ou "VIP")
    boolean aceita(String tipo);

    // Contém a lógica de validação e criação do objeto
    Usuario processar(UsuarioDTO dto);
}