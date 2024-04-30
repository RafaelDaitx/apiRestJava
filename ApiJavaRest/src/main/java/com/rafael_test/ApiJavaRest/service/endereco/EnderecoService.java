package com.rafael_test.ApiJavaRest.service.endereco;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;

import java.util.Optional;

public interface EnderecoService {

    Endereco salvarEnderecoPessoa(Long idPessoa, Endereco endereco);

    Optional<Endereco> buscarEndereco(Long id);

    Optional<Endereco> buscarTodosEnderecosPessoa(Long idPessoa);

    Optional<Pessoa> buscarEnderecoPessoa(Long idPessoa);

    Endereco atualizarEnderecoPessoa(Long id, Endereco endereco);

    void deletarEnderecoPessoa(Long id);
}
