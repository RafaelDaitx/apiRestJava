package com.rafael_test.ApiJavaRest.controller;

import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPeloId(id));
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarPessoa(pessoa));
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizarPessoa(pessoa));
    }

    public ResponseEntity<?> delete(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
