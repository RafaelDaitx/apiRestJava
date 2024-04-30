package com.rafael_test.ApiJavaRest.service.pessoaEndereco;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.model.PessoaEndereco;
import com.rafael_test.ApiJavaRest.repository.EnderecoRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaEnderecoRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import com.rafael_test.ApiJavaRest.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaEnderecoImpl implements PessoaEnderecoService{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;

    @Override
    public List<PessoaEndereco> buscarPessoaEndereco(Long idPessoa) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(idPessoa);

        //Rafael: fcicou pendente a implementação da busca de todos os endereços
        // de uma pessoa. Enfrentei certea dificuldade nessa parte por alguns problemas no retorno
        //da lista de endereço.
        return null;
    }

}
