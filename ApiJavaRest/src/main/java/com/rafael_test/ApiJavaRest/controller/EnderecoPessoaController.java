package com.rafael_test.ApiJavaRest.controller;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import com.rafael_test.ApiJavaRest.service.enderecoPessoa.EnderecoPessoaService;
import com.rafael_test.ApiJavaRest.service.pessoa.PessoaService;
import org.apache.velocity.exception.ResourceNotFoundException;
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

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Endereco novoEndereco) {
        try {
            enderecoPessoaService.atualizarEnderecoPessoa(id, novoEndereco);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Endereço não encontrado com o ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao processar a solicitação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEndereco(@PathVariable Long id){
        try {
            enderecoPessoaService.deletarEnderecoPessoa(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Endereço não encontrado com o ID: " + id);
        }
    }
}
