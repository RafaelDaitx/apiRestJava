package com.rafael_test.ApiJavaRest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_pessoa")
    private Pessoa idPessoa;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cep")
    private Long cep;

    @Column(name = "numero")
    private int numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "isEnderecoPrincipal")
    private boolean isEnderecoPrincipal;

    public Endereco() {
        // Nenhum código específico necessário aqui, apenas a definição do construtor vazio
    }
    public Endereco(Pessoa idPessoa, String logradouro,
                    Long cep,
                    int numero,
                    String cidade,
                    String estado,
                    boolean isEnderecoPrincipal) {
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.isEnderecoPrincipal = isEnderecoPrincipal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEnderecoPrincipal() {
        return isEnderecoPrincipal;
    }

    public void setEnderecoPrincipal(boolean enderecoPrincipal) {
        isEnderecoPrincipal = enderecoPrincipal;
    }
}
