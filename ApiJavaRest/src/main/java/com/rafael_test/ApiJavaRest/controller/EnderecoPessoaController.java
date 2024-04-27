package com.rafael_test.ApiJavaRest.controller;

import com.rafael_test.ApiJavaRest.model.EnderecoPessoa;
import com.rafael_test.ApiJavaRest.service.enderecoPessoa.EnderecoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/enderecoPessoa")
public class EnderecoPessoaController {

    @Autowired
    private EnderecoPessoaService enderecoPessoaService;

    @GetMapping
    public ResponseEntity<List<EnderecoPessoa>> findByIdPessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoPessoaService.buscarEndereco(idPessoa));
    }

    @PostMapping
    public ResponseEntity<EnderecoPessoa> create(@RequestBody EnderecoPessoa enderecoPessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoPessoaService.salvarEnderecoPessoa(enderecoPessoa));
    }
}
