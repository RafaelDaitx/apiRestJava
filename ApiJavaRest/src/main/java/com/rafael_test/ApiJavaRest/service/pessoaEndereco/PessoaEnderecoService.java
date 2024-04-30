package com.rafael_test.ApiJavaRest.service.pessoaEndereco;

import com.rafael_test.ApiJavaRest.model.PessoaEndereco;

import java.util.List;

public interface PessoaEnderecoService {

    List<PessoaEndereco> buscarPessoaEndereco(Long idPessoa);
}
