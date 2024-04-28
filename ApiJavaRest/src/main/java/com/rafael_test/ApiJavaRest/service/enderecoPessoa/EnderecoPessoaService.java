package com.rafael_test.ApiJavaRest.service.enderecoPessoa;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;

import java.util.Optional;

public interface EnderecoPessoaService {

    Endereco salvarEnderecoPessoa(Long idPessoa, Endereco endereco);

    Optional<Endereco> buscarEndereco(Long idPessoa);
    Optional<Pessoa> buscarEnderecoPessoa(Long idPessoa);

    Endereco atualizarEnderecoPessoa(Endereco endereco);

    void deletarEnderecoPessoa(Long id);
}
