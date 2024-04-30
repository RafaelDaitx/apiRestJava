package com.rafael_test.ApiJavaRest.controller;

import com.rafael_test.ApiJavaRest.model.PessoaEndereco;
import com.rafael_test.ApiJavaRest.service.pessoaEndereco.PessoaEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pessoa/endereco")
public class PessoaEnderecoController {
    @Autowired
    private PessoaEnderecoService pessoaEnderecoService;

    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<PessoaEndereco>> findById(@PathVariable Long idPessoa) {
        List<PessoaEndereco> enderecos = pessoaEnderecoService.buscarPessoaEndereco(idPessoa);
        return ResponseEntity.ok(enderecos);
    }
}

