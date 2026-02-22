package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("VIP")
public class UsuarioVIP extends Usuario {

    private boolean temCartaoFidelidade;

    public boolean isTemCartaoFidelidade() {
        return temCartaoFidelidade;
    }

    public void setTemCartaoFidelidade(boolean temCartaoFidelidade) {
        this.temCartaoFidelidade = temCartaoFidelidade;
    }

    @Override
    public int getDesconto() {
        // Solução do professor para o LSP: Retornar 0 no lugar do throw!
        if (!temCartaoFidelidade) {
            return 0;
        }
        return 10; // desconto de 10% para usuários VIP
    }
}