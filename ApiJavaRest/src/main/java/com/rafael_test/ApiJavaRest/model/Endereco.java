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
}
