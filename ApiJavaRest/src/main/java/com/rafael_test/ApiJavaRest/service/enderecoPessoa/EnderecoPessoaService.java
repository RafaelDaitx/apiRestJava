package com.rafael_test.ApiJavaRest.service.enderecoPessoa;

import com.rafael_test.ApiJavaRest.model.EnderecoPessoa;
import com.rafael_test.ApiJavaRest.model.Pessoa;

import java.util.List;

public interface EnderecoPessoaService {

    EnderecoPessoa salvarEnderecoPessoa(EnderecoPessoa enderecoPessoa);

    List<EnderecoPessoa> buscarEndereco(Long idPessoa);

    EnderecoPessoa atualizarEnderecoPessoa(EnderecoPessoa enderecoPessoa);

    void deletarEnderecoPessoa(Long id);
}
