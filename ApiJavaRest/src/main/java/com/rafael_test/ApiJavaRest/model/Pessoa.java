package com.rafael_test.ApiJavaRest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nomePessoa")
    private String nomePessoa;

    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "idPessoa",  fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Endereco> enderecos;

}
