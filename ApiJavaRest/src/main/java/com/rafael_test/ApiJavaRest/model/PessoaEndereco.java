package com.rafael_test.ApiJavaRest.model;

import java.util.List;

public class PessoaEndereco {
    private Pessoa pessoa;
    private List<Endereco> endereco;

    public PessoaEndereco(Pessoa pessoa, List<Endereco> endereco) {
        this.pessoa = pessoa;
        this.endereco = endereco;
    }

    // Getters e Setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
