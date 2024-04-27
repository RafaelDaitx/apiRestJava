package com.rafael_test.ApiJavaRest.service.pessoa;

import com.rafael_test.ApiJavaRest.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    Pessoa salvarPessoa(Pessoa pessoa);

    List<Pessoa> buscarPessoas();

    Optional<Pessoa> buscarPeloId(Long id);

    Pessoa atualizarPessoa(Pessoa pessoa);

    void deletarPessoa(Long id);

}
