package com.rafael_test.ApiJavaRest.controller;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import com.rafael_test.ApiJavaRest.service.enderecoPessoa.EnderecoPessoaService;
import com.rafael_test.ApiJavaRest.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/enderecoPessoa")
public class EnderecoPessoaController {

    @Autowired
    private EnderecoPessoaService enderecoPessoaService;

    @Autowired
    private PessoaService pessoaService;


    @GetMapping("/{idPessoa}")
    public ResponseEntity<Optional<Endereco>> findByIdPessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoPessoaService.buscarEndereco(idPessoa));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable Long idPessoa, @RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoPessoaService.salvarEnderecoPessoa(idPessoa, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEndereco(@PathVariable Long id){
        var existeEndereco = enderecoPessoaService.buscarEndereco(id);
        if(existeEndereco == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else {
            enderecoPessoaService.deletarEnderecoPessoa(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
