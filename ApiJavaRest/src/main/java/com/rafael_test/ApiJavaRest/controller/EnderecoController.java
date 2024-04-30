package com.rafael_test.ApiJavaRest.controller;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.repository.EnderecoRepository;
import com.rafael_test.ApiJavaRest.service.endereco.EnderecoService;
import com.rafael_test.ApiJavaRest.service.pessoa.PessoaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/enderecoPessoa")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoPessoaService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Optional<Endereco>> findByIdPessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoPessoaService.buscarEndereco(idPessoa));
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable Long idPessoa, @RequestBody Endereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoPessoaService.salvarEnderecoPessoa(idPessoa, endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Endereco novoEndereco) {
        try {
            return enderecoPessoaService.buscarEndereco(id).map(
                    buscaEndereco -> {
                        if (novoEndereco.isEnderecoPrincipal()) {
                            // Busca o endereço associado à mesma pessoa (idPessoa)
                            Optional<Endereco> outrosEnderecos = enderecoPessoaService.buscarEndereco(buscaEndereco.getIdPessoa().getId());

                            outrosEnderecos.ifPresent(outroEndereco -> {
                                outroEndereco.setEnderecoPrincipal(false);
                                enderecoPessoaService.atualizarEnderecoPessoa(outroEndereco.getId(), outroEndereco);
                            });
                        }

                        // Atualiza o endereço principal
                        enderecoPessoaService.atualizarEnderecoPessoa(id, novoEndereco);

                        return ResponseEntity.status(HttpStatus.OK).build();
                    }
            ).orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + id));

        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Endereço não encontrado com o ID: " + id);
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
