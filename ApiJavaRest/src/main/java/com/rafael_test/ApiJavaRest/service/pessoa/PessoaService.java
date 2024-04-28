package com.rafael_test.ApiJavaRest.service.pessoa;

import com.rafael_test.ApiJavaRest.model.Pessoa;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    Pessoa salvarPessoa(Pessoa pessoa);

    List<Pessoa> buscarPessoas();

    Optional<Pessoa> buscarPeloId(Long id);

    Pessoa atualizarPessoa(Long id, Pessoa pessoa);

    void deletarPessoa(Long id);

}
