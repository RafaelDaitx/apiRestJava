package com.rafael_test.ApiJavaRest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EnderecoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pesssoa")
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
}
